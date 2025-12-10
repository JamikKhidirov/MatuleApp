package com.example.uikit.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview
fun ProfileScreen(){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

        }
    ) { paddingValues ->
        BottomProfileScreen(
           paddingValues = paddingValues,
            onClickButtonLogOut = {

            }
        )
    }
}



@Composable
fun BottomProfileScreen(
    paddingValues: PaddingValues,
    onClickButtonLogOut: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(top = 80.dp),
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