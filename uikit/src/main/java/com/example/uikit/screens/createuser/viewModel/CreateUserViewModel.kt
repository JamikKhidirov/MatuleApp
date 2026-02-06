package com.example.uikit.screens.createuser.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.data.userdata.RequestRegister
import com.example.network.data.userdata.User
import com.example.network.service.ApiUserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CreateUserViewModel @Inject constructor(
    private val userApi: ApiUserService
) : ViewModel() {

    var loading = MutableStateFlow(false)
    var error = MutableStateFlow<String?>(null)

    private var email: String = ""
    private var firstName: String = ""
    private var lastName: String = ""
    private var secondName: String = ""
    private var datebirthday: String = ""
    private var gender: String = ""

    private companion object {
        const val TAG = "CreateUserViewModel"
    }

    suspend fun saveProfileData(
        email: String,
        firstName: String,
        lastName: String,
        secondName: String,
        datebirthday: String,
        gender: String,
    ) {
        Log.d(TAG, "Сохранение данных профиля: email=$email, firstName=$firstName")
        this.firstName = firstName
        this.lastName = lastName
        this.secondName = secondName
        this.datebirthday = datebirthday
        this.gender = gender
        this.email = email
    }

    fun registerUser(
        password: String,
        passwordConfirm: String,
        onSuccess: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            loading.value = true
            error.value = null

            Log.d(TAG, "Начало регистрации пользователя: email=$email")

            try {
                // Логируем запрос
                Log.d(TAG, "Создание пользователя: email=$email, passwordLength=${password.length}")

                // Создаём пользователя (только email + password)
                val response = userApi.createUser(
                    requestRegister = RequestRegister(
                        email = email,
                        password = password,
                        passwordConfirm = passwordConfirm
                    )
                )

                Log.d(TAG, "Ответ от API создания пользователя: code=${response.code()}, message=${response.message()}")

                if (!response.isSuccessful) {
                    val errorMessage = "Ошибка регистрации: ${response.code()} - ${response.message()}"
                    Log.e(TAG, errorMessage)
                    error.value = errorMessage
                    loading.value = false
                    onSuccess(false)
                    return@launch
                }

                val createdUser = response.body()!!
                Log.d(TAG, "Пользователь создан успешно: id=${createdUser.id}")

                // После создания - обновляем остальные поля
                Log.d(TAG, "Обновление профиля пользователя: firstName=$firstName, lastName=$lastName")
                val updateUserResponse = updateUser(createdUser.id)

                if (updateUserResponse.isSuccessful) {
                    Log.d(TAG, "Профиль пользователя успешно обновлен")
                    onSuccess(true)
                } else {
                    val errorMessage = "Ошибка обновления профиля: ${updateUserResponse.code()}"
                    Log.e(TAG, errorMessage)
                    error.value = errorMessage
                    onSuccess(false)
                }

            } catch (e: Exception) {
                val errorMessage = "Исключение при регистрации: ${e.localizedMessage}"
                Log.e(TAG, errorMessage, e)
                error.value = errorMessage
                onSuccess(false)
            } finally {
                loading.value = false
                Log.d(TAG, "Регистрация завершена, loading=false")
            }
        }
    }

    private fun String.toPart() =
        this.toRequestBody("text/plain".toMediaTypeOrNull())


    private suspend fun updateUser(userId: String): Response<User> {
        Log.d(TAG, "Отправка данных для обновления пользователя $userId")

        val params = mapOf(
            "firstname" to firstName.toPart(),
            "secondname" to secondName.toPart(),
            "lastname" to lastName.toPart(),
            "datebirthday" to datebirthday.toPart(),
            "gender" to gender.toPart()
        )

        return userApi.updateUser(userId, params)
    }
}