package com.example.uikit.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.screencomponents.HelpWellcomeText
import com.example.uikit.screencomponents.TextDescription
import com.example.uikit.screencomponents.TextInputUser
import com.example.uikit.screencomponents.WelcomeText


@Composable
@Preview
fun RegisterScreen(){

    var isRotation by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {paddingValues ->
        RegisterScreenBottom(
            paddingValues = paddingValues,
            isRotation = isRotation,
            onClickVizIcon = {
                isRotation = !isRotation
            },
            onTextEmailUser = {EmailText ->
                email = EmailText
            },
            onTextPasswordUser = { passswordText ->
                password = passswordText
            }
        )
    }
}



@Composable
fun RegisterScreenBottom(
    paddingValues: PaddingValues,
    isRotation: Boolean,
    onClickVizIcon: () -> Unit,
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
                    top = 59.dp
                )
            )

            HelpWellcomeText(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 23.dp)

            )


        }

        TextDescription(
            modifier = Modifier,
            colorText = colorResource(R.color.TextDescriptionColor)
        )

        TextInputUser(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 50.dp),
            onClickVizIcon = onClickVizIcon,
            onTextValueUser = onTextEmailUser,
            isRotation = isRotation,
            passwordTextInput = false,
            isGender = false
        )

        TextInputUser(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 4.dp),
            onTextValueUser = onTextPasswordUser
        )




    }
}
