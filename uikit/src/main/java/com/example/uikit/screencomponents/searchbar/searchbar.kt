package com.example.uikit.screencomponents.searchbar


import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.sfProDisplay


@Composable
@Preview
fun searchbar(
    value: String = "",
    modifier: Modifier = Modifier,
    onClickIxSerch: () -> Unit = {},
    onSearchInfo: (String) -> Unit = {},
    onValueChange: (String) -> Unit = {}
){

    var text = remember { mutableStateOf(value) }

    LaunchedEffect(text.value) {
        if (text.value.isNotEmpty()){
            onSearchInfo(text.value)
        }
    }

    TextField(
        value = text.value,
        onValueChange = {newString ->
            text.value = newString
            onValueChange(newString)
        },
        modifier = Modifier
            .border(
                1.dp,
                color = Color(0xFFEBEBEB)
            ).then(modifier),

        shape = RoundedCornerShape(10.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.serachicon),
                contentDescription = ""
            )
        },

        trailingIcon = {
           if (text.value.isNotEmpty()){
               IconButton(
                   onClick = {
                       onClickIxSerch()
                       text.value = ""
                   }
               ) {
                   Icon(
                       painter = painterResource(R.drawable.ixisearch),
                       contentDescription = "Иконка X для стирания поля ввода"
                   )
               }
           }
        },

        placeholder = {
            Text(
                "Искать  описания",
                color = Color(0xFF939396),
                fontSize = 16.sp,
                fontFamily = sfProDisplay
            )
        },

        colors = TextFieldDefaults.colors(
            cursorColor = colorResource(R.color.buttonColor),
            unfocusedContainerColor = Color(0XFFEBEBEB),
            focusedContainerColor = Color(0XFFEBEBEB),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )

    )


}