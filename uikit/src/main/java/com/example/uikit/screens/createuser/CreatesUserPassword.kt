package com.example.uikit.screens.createuser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.uikit.screencomponents.buttons.ButtonScreens
import com.example.uikit.screencomponents.text.TextDescription
import com.example.uikit.screencomponents.text.WelcomeText
import com.example.uikit.screencomponents.textInput.TextInputUser
import kotlinx.coroutines.launch
import navigation.destinations.AuthDestination
import com.example.uikit.screens.createuser.viewModel.CreateUserViewModel


@Composable
fun CreateUserPassword(
    navController: NavController,
    viewModel: CreateUserViewModel
) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    var newpass by remember { mutableStateOf("") }
    var confirmpass by remember { mutableStateOf("") }
    var newPassViz by remember { mutableStateOf(false) }
    var newPassConfirmViz by remember { mutableStateOf(false) }

    val enableButton by remember(newpass, confirmpass) {
        derivedStateOf {
            newpass.isNotEmpty() && confirmpass.isNotEmpty()
        }
    }

    // Observe ViewModel state
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

    // Show error in Snackbar
    LaunchedEffect(error) {
        error?.let { errorMessage ->
            snackbarHostState.showSnackbar(message = errorMessage)
            // Clear error after showing
            viewModel.error.value = null
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState ) { data ->
                Snackbar(
                    modifier = Modifier.padding(16.dp),
                    snackbarData = data
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                WelcomeText(
                    text = "Создание пароля",
                    modifier = Modifier.padding(top = 60.dp)
                )

                TextDescription(
                    text = "Введите новый пароль",
                    modifier = Modifier.padding(top = 23.dp),
                    colorText = Color.Black
                )

                TextDescription(
                    text = "Новый Пароль",
                    modifier = Modifier.padding(top = 90.dp)
                )

                TextInputUser(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    value = newpass,
                    placeholder = "",
                    passwordTextInput = true,
                    passwordViz = newPassViz,
                    onTextValueUser = { newPassword ->
                        newpass = newPassword
                    },
                    onClickVizIcon = {
                        newPassViz = !newPassViz
                    }
                )

                TextDescription(
                    text = "Повторите пароль",
                    modifier = Modifier.padding(top = 12.dp)
                )

                TextInputUser(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    value = confirmpass,
                    placeholder = "",
                    passwordTextInput = true,
                    passwordViz = newPassConfirmViz,
                    onTextValueUser = { confirmPassword ->
                        confirmpass = confirmPassword
                    },
                    onClickVizIcon = {
                        newPassConfirmViz = !newPassConfirmViz
                    }
                )


                ButtonScreens(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .height(56.dp),
                    loading = loading,
                    enableButton = enableButton && !loading,
                    onClickButton = {
                        viewModel.registerUser(
                            password = newpass,
                            passwordConfirm = confirmpass
                        ) { success ->
                            if (success) {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Регистрация успешна"
                                    )
                                    navController.navigate(AuthDestination.LoginScreen)
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}