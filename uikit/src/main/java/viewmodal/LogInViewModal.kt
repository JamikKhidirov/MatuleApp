package viewmodal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.TokenDataStore
import com.example.network.data.userdata.RequestAuth
import com.example.network.data.userdata.RequestUser
import com.example.network.service.ApiUserService
import com.example.network.statenetworkmodel.NetworkInstance
import com.example.network.statenetworkmodel.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import viewmodal.states.LogInUiState
import viewmodal.states.UiEvent
import javax.inject.Inject


@HiltViewModel
class LogInViewModal @Inject constructor(
    private val api: ApiUserService,
    private val tokenDataStore: TokenDataStore
) : ViewModel(){
    var uiState by mutableStateOf(LogInUiState())
        private set

    private val _events = MutableSharedFlow<UiEvent>()
    val events = _events.asSharedFlow()

    fun logIn(email: String, password: String){
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)
            val user = RequestAuth(identity = email, password = password)
            try {
                val response = api.logInUser(user)

                when(response.isSuccessful){
                    true -> {
                        val body = response.body() ?: throw Exception("Нету данных")
                        tokenDataStore.clearToken()
                        tokenDataStore.saveToken(body.token)

                        uiState = uiState.copy(isLoading = false, isSuccess = true)
                    }

                    false -> {
                        uiState = uiState.copy(
                            isLoading = false,
                            error = "Неверный email или пароль"
                        )
                        _events.emit(UiEvent.ShowSnackbar("Неверный email или пароль"))
                        return@launch
                    }
                }

            }
            catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error"
                )
            }

        }
    }

}