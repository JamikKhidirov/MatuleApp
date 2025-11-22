package com.example.uikit.screencomponents.buttons


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.sfProDisplay


@Composable
@Preview(showBackground = true)
fun textBtn(
    text: String = "Зарегистрироваться",
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        modifier = modifier,
        color = colorResource(R.color.textBtnColor),
        fontSize = 15.sp,
        fontFamily = sfProDisplay
    )
}