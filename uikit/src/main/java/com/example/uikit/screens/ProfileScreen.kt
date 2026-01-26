package com.example.uikit.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
fun ProfileScreen(
    onClickButtonLogOut: () -> Unit = {}
){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Эдуард",
            modifier = Modifier.align(Alignment.Start)
                .padding(
                    start = 20.dp,
                    top = 30.dp
                ),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
            )
        Text(
            "afersfsr@dsfsr.ru",
            modifier = Modifier.align(Alignment.Start)
                .padding(
                    top = 8.dp,
                    start = 20.dp
                    ),
            fontSize = 16.sp,
            color = Color(0xFF939396)
        )




        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Политика конфиденциальности",
                    color = Color(0xFF939396),
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(24.dp))  // ← Ручной отступ
                Text(
                    text = "Пользовательское соглашение",
                    color = Color(0xFF939396),
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(24.dp))  // ← Ручной отступ

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
}



