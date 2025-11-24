package com.example.uikit.screencomponents.text


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.sfProDisplay


@Composable
fun TextDescription(
    text: String = "Вход по E-mail",
    fontSize: TextUnit = 14.sp,
    modifier: Modifier = Modifier,
    colorText: Color = colorResource(R.color.TextDescriptionColor)
){
    Text(
        text = text,
        modifier = modifier,
        color = colorText,
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.W200
        )
}