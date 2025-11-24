package viewmodal


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.data.userdata.RequestRegister
import com.example.network.data.userdata.User
import com.example.network.service.ApiUserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class CreateUserViewModel @Inject constructor(
    private val userApi: ApiUserService
): ViewModel() {

    var loading = MutableStateFlow(false)
    var error = MutableStateFlow<String?>(null)

    private var email: String = ""
    private var emailVisibility: Boolean = true
    private var firstName: String = ""
    private var lastName: String = ""
    private var secondName: String = ""
    private var datebirthday: String = ""
    private var gender: String = ""



    suspend fun saveProfileData(
        email: String,
        firstName: String,
        lastName: String,
        secondName: String,
        datebirthday: String,
        gender: String,
    ){
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
        onSuccess: () -> Unit
    ){
        viewModelScope.launch {
            loading.value = true
            error.value = null

            try {
                // Создаём пользователя (только email + password)
                val response = userApi.createUser(
                    requestRegister = RequestRegister(
                        email = email,
                        password = password,
                        passwordConfirm = passwordConfirm
                    )
                )

                if (!response.isSuccessful) {
                    error.value = "Ошибка регистрации: ${response.message()}"
                    loading.value = false
                    return@launch
                }

                val createdUser = response.body()!!

                // после создания - обновляем остальные поля
                val updateUserResponce = updateUser(createdUser.id)

                if (updateUserResponce.isSuccessful){
                    onSuccess()
                }


            }
            catch (e: Exception){
                error.value = e.localizedMessage
            }

            finally {
                loading.value = false
            }
        }
    }


    private suspend fun updateUser(userId: String): Response<User> {

        val params = mapOf(
            "firstname" to firstName.toRequestBody(),
            "secondname" to secondName.toRequestBody(),
            "lastname" to lastName.toRequestBody(),
            "datebirthday" to datebirthday.toRequestBody(),
            "gender" to gender.toRequestBody()
        )

        return userApi.updateUser(userId, params)
    }
}
