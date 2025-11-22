package com.example.uikit.screencomponents.text


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.uikit.theme.sfProDisplay


@Composable
fun TextDescription(
    text: String = "Вход по E-mail",
    modifier: Modifier = Modifier,
    colorText: Color
){
    Text(
        text = text,
        modifier = modifier,
        color = colorText,
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.W200
        )
}