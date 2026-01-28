package com.example.uikit.screens.profile

import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.screencomponents.buttons.CastomSwitch
import com.example.uikit.screens.profile.uicomponents.topBarProfileScreen
import com.example.uikit.screens.profile.uicomponents.vidjetProfileScreen


@Composable
@Preview
fun ProfileScreen(){

    var chechSwitch by remember { mutableStateOf(false) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

        }
    ) { paddingValues ->
        BottomProfileScreen(
           paddingValues = paddingValues,
            onClickButtonLogOut = {

            },
            check = chechSwitch,
            onChackedChange = { switchState ->
                 chechSwitch = !switchState
            }
        )
    }
}



@Composable
fun BottomProfileScreen(
    paddingValues: PaddingValues,
    onClickButtonLogOut: () -> Unit,
    check: Boolean = false,
    onChackedChange: (Boolean) -> Unit = {}
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues),

    ) {

        topBarProfileScreen(
            modifier = Modifier
                .padding(top = 32.dp)
                .padding(start = 20.dp)
        )


        vidjetProfileScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .padding(horizontal = 20.dp),

        )

        vidjetProfileScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            icon = com.example.uikit.R.drawable.settings,
            text = "Уведомления",
            swithch = {
                CastomSwitch(
                    modifier = Modifier
                        .padding(start = 60.dp)
                        .size(width = 48.dp, height = 28.dp),
                    check = check,
                    onCheckedChange = onChackedChange,
                     scale = 1.2f
                )
            }
        )



        Column(
            modifier = Modifier
                .padding(top = 90.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "Политика конфиденциальности",
                color = Color(0xFF939396),
                fontSize = 15.sp
            )
            Text(
                text = "Пользовательское соглашение",
                color = Color(0xFF939396),
                fontSize = 15.sp
            )

            TextButton(
                onClick = onClickButtonLogOut
            ) {
                Text(
                    text = "Выход",
                    color = Color(0xFFFD3535),
                    modifier = Modifier.padding(horizontal = 40.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}