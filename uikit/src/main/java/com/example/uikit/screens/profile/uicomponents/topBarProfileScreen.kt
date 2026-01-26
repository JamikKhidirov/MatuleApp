package com.example.uikit.screens.profile.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
fun topBarProfileScreen(
    modifier: Modifier = Modifier,
    name: String = "Эдуард",
    email: String = "afersfsr@dsfsr.ru"
){

    Column(
        modifier = modifier
    ) {
        Text(
            text = name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = email,
            fontSize = 20.sp,
            color = Color(0xFF939396),
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}