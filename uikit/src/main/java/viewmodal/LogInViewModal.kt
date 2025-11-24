package viewmodal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.TokenDataStore
import com.example.network.service.ApiUserService
import com.example.network.statenetworkmodel.NetworkInstance
import com.example.network.statenetworkmodel.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import viewmodal.states.LogInUiState
import javax.inject.Inject


@HiltViewModel
class LogInViewModal @Inject constructor(
    val api: ApiUserService
) : ViewModel(){

    var uiState by mutableStateOf(LogInUiState())
        private set

    fun logIn(email: String, password: String){
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)

            try {

            }
            catch (e: Exception){

            }
            finally {

            }
        }
    }

}