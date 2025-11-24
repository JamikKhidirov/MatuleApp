package com.example.uikit.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.uikit.screencomponents.buttons.ButtonScreens
import com.example.uikit.screencomponents.text.TextDescription
import com.example.uikit.screencomponents.text.WelcomeText
import com.example.uikit.screencomponents.textInput.TextInputUser
import kotlinx.coroutines.launch
import navigation.Destination
import retrofit2.Response
import viewmodal.CreateUserViewModel


@SuppressLint("RememberReturnType")
@Composable
fun CreateUserScreen(
    viewModel: CreateUserViewModel = hiltViewModel(),
    navController: NavController
){

    var userName by remember { mutableStateOf("") }
    var patronymic by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var gender by remember {mutableStateOf("")}
    var email by remember { mutableStateOf("") }

    var isRotation by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    val enableButton by remember(
        userName, patronymic,
        surname, date,
        gender, email
    ) {
        derivedStateOf {
            userName.isNotBlank() &&
                    patronymic.isNotBlank() &&
                    surname.isNotBlank() &&
                    date.isNotBlank() &&
                    gender.isNotBlank() &&
                    email.isNotBlank()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 20.dp)
            .statusBarsPadding(),
    ) {
        WelcomeText(
            text = "Создание Профиля",
            iconEnable = false,
            modifier = Modifier.padding(top = 32.dp)
        )

        TextDescription(
            text = "Без профиля вы не сможете создавать проекты.",
            modifier = Modifier.padding(top = 44.dp)
        )

        TextDescription(
            text = "В профиле будут храниться результаты проектов и ваши описания",
            modifier = Modifier.padding(top = 8.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ){
            TextInputUser(
                value = userName,
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Имя",
                onTextValueUser = {name ->
                    userName = name
                },
            )

            TextInputUser(
                value = patronymic,
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Отчество",
                onTextValueUser = { pat ->
                    patronymic = pat
                }
            )

            TextInputUser(
                value = surname,
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Фамилия",
                onTextValueUser = { surName ->
                    surname = surName
                }
            )

            TextInputUser(
                value = date,
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Дата рождения",
                onTextValueUser = { dateTime ->
                    date = dateTime
                }
            )

            TextInputUser(
                modifier = Modifier.fillMaxWidth(),
                value = gender,
                placeholder = "Пол",
                isGender = true,
                isRotation = isRotation,
                onTextValueUser = { genderText ->
                    gender = genderText
                },
                onClickVizIcon = {
                    isRotation = !isRotation
                },
            )

            TextInputUser(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                placeholder = "Почта",
                onTextValueUser = { emailUser ->
                    email = emailUser
                }
            )

            ButtonScreens(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 30.dp)
                    .height(60.dp),
                enableButton = enableButton,
                onClickButton = {
                    scope.launch {
                        // 1) сохраняем данные во ViewModel
                        viewModel.saveProfileData(
                            firstName = userName,
                            secondName = patronymic,
                            lastName = surname,
                            datebirthday = date,
                            gender = gender,
                            email = email
                        )
                    }
                    navController.navigate(Destination.CreateUserPassword)
                }
            )
        }

    }
}