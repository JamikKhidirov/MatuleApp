package viewmodal.states



data class LogInUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)

sealed class UiEvent{
    data class ShowSnackbar(val message: String) : UiEvent()
}
