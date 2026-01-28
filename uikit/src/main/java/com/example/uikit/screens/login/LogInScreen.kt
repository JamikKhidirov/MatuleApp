package com.example.uikit.screens.login


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.uikit.R
import com.example.uikit.screencomponents.buttons.ButtonScreens
import com.example.uikit.screencomponents.buttons.OutLineButtonScreens
import com.example.uikit.screencomponents.buttons.textBtn
import com.example.uikit.screencomponents.text.HelpWellcomeText
import com.example.uikit.screencomponents.text.TextDescription
import com.example.uikit.screencomponents.textInput.TextInputUser
import com.example.uikit.screencomponents.text.WelcomeText
import kotlinx.coroutines.delay
import navigation.AuthDestination
import navigation.HomeDestination
import viewmodal.LogInViewModel
import viewmodal.states.UiEvent


@Composable
fun LogInScreenScreen(
    viewModal: LogInViewModel = hiltViewModel(),
    navController: NavController
) {
    var isRotation by remember { mutableStateOf(false) }
    var passwordViz by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // ИСПРАВЛЕНО: Используем collectAsStateWithLifecycle для сбора StateFlow
    val state by viewModal.uiState.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    var navigate by remember { mutableStateOf(false) }

    // Навигация при успешном входе
    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) {
            // Небольшая задержка для отображения успеха
            delay(300)
            navController.navigate(HomeDestination.HomeScreen) {
                // Очищаем стек навигации
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }
        }
    }

    LaunchedEffect(navigate) {
        if (navigate) {
            navController.navigate(AuthDestination.CreateUserScreen)
            delay(500)
            navigate = false
        }
    }

    // Ловим ошибки из ViewModel
    LaunchedEffect(Unit) {
        viewModal.events.collect { event ->
            when(event) {
                is UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = "OK",
                        duration = SnackbarDuration.Short
                    )
                }
            }
        }
    }

    val enableButton by remember(email, password, state.isLoading) {
        derivedStateOf {
            email.isNotEmpty() && password.isNotEmpty() && !state.isLoading
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { snackbarData ->
                Snackbar(
                    snackbarData = snackbarData,
                    modifier = Modifier.padding(16.dp),
                    containerColor = Color(0xFFD32F2F),
                    contentColor = Color.White
                )
            }
        }
    ) { paddingValues ->
        // Убираем проверку isSuccess из onClickLogInButton
        // так как навигация теперь в LaunchedEffect
        LogInScreenBottom(
            paddingValues = paddingValues,
            email = email,
            password = password,
            isRotation = isRotation,
            enableButton = enableButton,
            passwordViz = passwordViz,
            onClickTextRegister = {
                navigate = true
            },
            onClickVizIcon = {
                passwordViz = !passwordViz
            },
            onClickVkLog = { },
            onClickLogInButton = {
                viewModal.logIn(email = email, password = password)
                // УБРАНО: if (state.isSuccess) - навигация теперь в LaunchedEffect
            },
            onClickYndexLogIn = { },
            onTextEmailUser = { EmailText ->
                email = EmailText
            },
            onTextPasswordUser = { passwordText ->
                password = passwordText
            }
        )
    }
}


@Composable
fun LogInScreenBottom(
    paddingValues: PaddingValues,
    email: String,
    password: String,
    isRotation: Boolean,
    enableButton: Boolean,
    passwordViz: Boolean,
    onClickTextRegister: () -> Unit,
    onClickVkLog: () -> Unit,
    onClickYndexLogIn: () -> Unit,
    onClickVizIcon: () -> Unit,
    onClickLogInButton: () -> Unit,
    onTextEmailUser: (String) -> Unit,
    onTextPasswordUser: (String) -> Unit,
    ) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(paddingValues)){

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            WelcomeText(
                modifier = Modifier.padding(
                    top = 40.dp
                )
            )

            HelpWellcomeText(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 23.dp)

            )


        }

        TextDescription(
            modifier = Modifier
                .padding(top = 50.dp)
                .padding(start = 20.dp),
            colorText = colorResource(R.color.TextDescriptionColor)
        )

        TextInputUser(
            value = email,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 4.dp),
            onTextValueUser = onTextEmailUser,
            isRotation = isRotation,
            passwordViz = true,
            passwordTextInput = false,
            isGender = false
        )

        TextDescription(
            modifier = Modifier
                .padding(top = 15.dp)
                .padding(start = 20.dp),
            colorText = colorResource(
                R.color.TextDescriptionColor
            ),
            text = "Пороль"
        )

        TextInputUser(
            value = password,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 4.dp),
            onTextValueUser = onTextPasswordUser,
            onClickVizIcon = onClickVizIcon,
            passwordViz = passwordViz,
            passwordTextInput = true,
            placeholder = null
        )

        ButtonScreens(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 15.dp)
                .height(56.dp),
            enableButton = enableButton,
            onClickButton = onClickLogInButton
        )

        textBtn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(top = 25.dp)
                .clickable{
                    onClickTextRegister()
                },
        )


        Column (
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 60.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextDescription(
                text = "Или войдите с помощью",
                modifier = Modifier.fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )

            OutLineButtonScreens(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickVkLog
            )

            OutLineButtonScreens(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.yndexvector),
                text = "Войти с Yandex",
                isYndex = true,
                onClick = onClickYndexLogIn)

        }
    }
}



@Composable
@Preview(showBackground = true)
fun LogInScreenPreview(){
    LogInScreenScreen(
        navController = rememberNavController()
    )
}
