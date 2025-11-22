package com.example.uikit.screencomponents.text


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.sfProDisplay


@Composable
fun WelcomeText(
    text: String = "Добро пожаловать!",
    iconEnable: Boolean = true,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier.fillMaxWidth().then(modifier),
        verticalAlignment = Alignment.CenterVertically,
    ) {

       if (iconEnable){
           Icon(
               painter = painterResource(R.drawable.hello),
               contentDescription = "",
               tint =  Color.Unspecified,
               modifier = Modifier
                   .padding(end = 16.dp)
                   .size(32.dp)
           )
       }

        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}



@Composable
@Preview(showBackground = true)
fun HelpWellcomeText(
    modifier: Modifier = Modifier
){
    Text(
        text = "Войдите, чтобы пользоваться функциями приложения",
        fontSize = 15.sp,
        fontFamily = sfProDisplay,
        color = Color.Black,
        modifier = modifier
    )
}