package com.example.uikit.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.screencomponents.buttons.ButtonScreens
import com.example.uikit.screencomponents.indicators.PinIndicator
import com.example.uikit.screencomponents.text.TextDescription
import com.example.uikit.screencomponents.text.WelcomeText
import com.example.uikit.screencomponents.textInput.TextInputUser


@Composable
@Preview(showBackground = true)
fun CreateUserPassword(){

    var newpass by remember { mutableStateOf("") }
    var confirmpass by remember { mutableStateOf("") }

    var newPassViz by remember { mutableStateOf(false) }
    var newPassConfirmViz by remember { mutableStateOf(false) }


    val enableButton by remember(newpass, confirmpass) {
        derivedStateOf {
            newpass.isNotEmpty() && confirmpass.isNotEmpty()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            WelcomeText(
                text = "Создание пороля",
                modifier = Modifier.padding(top = 60.dp)
            )

            TextDescription(
                text = "Введите новый пароль",
                modifier = Modifier.padding(top = 23.dp),
                colorText = Color.Black
            )

            TextDescription(
                text = "Новый Пороль",
                modifier = Modifier
                    .padding(top = 90.dp)
            )

            TextInputUser(
                modifier = Modifier.fillMaxWidth()
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
                text = "Повторите пороль",
                modifier = Modifier.padding(top = 12.dp)
            )

            TextInputUser(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 4.dp),
                value = confirmpass,
                placeholder = "",
                passwordTextInput = true,
                passwordViz = newPassConfirmViz,
                onTextValueUser = {confirmPassword ->
                    confirmpass = confirmPassword
                },
                onClickVizIcon = {
                    newPassConfirmViz = !newPassConfirmViz
                }
            )

            ButtonScreens(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 20.dp)
                    .height(56.dp),
                enableButton = enableButton,
                onClickButton = {

                }
            )



        }
    }
}