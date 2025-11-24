package viewmodal.states



data class LogInUiState(
    val isLoading: Boolean = false,
    val success: Boolean = false,
    val error: String? = null
)
