package viewmodal

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.AuthRepository
import com.example.network.data.userdata.RequestAuth
import com.example.network.service.ApiUserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import viewmodal.states.LogInUiState
import viewmodal.states.UiEvent
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class LogInViewModel @Inject constructor(
    private val api: ApiUserService,
    private val tokenDataStore: AuthRepository
) : ViewModel() {

    // Используем MutableStateFlow для Compose
    private val _uiState = MutableStateFlow(LogInUiState())
    val uiState = _uiState.asStateFlow()

    // LiveData для старых ViewModels или StateFlow для Compose
    private val _events = MutableSharedFlow<UiEvent>()
    val events = _events.asSharedFlow()

    fun logIn(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null,
                isSuccess = false  // Сбрасываем success при новом запросе
            )

            val user = RequestAuth(identity = email, password = password)
            try {
                val response = api.logInUser(user)

                when {
                    response.isSuccessful -> {
                        val body = response.body() ?: throw Exception("Нету данных")
                        Log.d("network", body.toString())

                        // Сохраняем токен
                        tokenDataStore.saveAuthToken(body.token)

                        // Устанавливаем успех
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            isSuccess = true,
                            error = null
                        )
                    }

                    else -> {
                        val errorMessage = when (response.code()) {
                            401 -> "Неверный email или пароль"
                            400 -> "Некорректные данные"
                            404 -> "Пользователь не найден"
                            else -> "Ошибка сервера: ${response.code()}"
                        }

                        Log.d("network", "Error: ${response.errorBody()?.string()}")
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            error = errorMessage
                        )

                        // Показываем снекбар
                        _events.emit(UiEvent.ShowSnackbar(errorMessage))
                    }
                }
            } catch (e: Exception) {
                val errorMessage = when (e) {
                    is IOException -> "Проверьте подключение к интернету"
                    else -> e.message ?: "Неизвестная ошибка"
                }

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = errorMessage
                )
                _events.emit(UiEvent.ShowSnackbar(errorMessage))
                Log.e("network", "Login error", e)
            }
        }
    }
}
