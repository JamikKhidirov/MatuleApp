package com.example.uikit.screencomponents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.trace
import com.example.uikit.R
import com.example.uikit.theme.sfProDisplay



@Composable
@Preview(showBackground = true)
fun TextInputUser(
    onTextValueUser: (String) -> Unit = {},
    placeholder: String? = "example@gmail.com",
    passwordTextInput: Boolean = false,
    passwordViz: Boolean = true,
    modifier: Modifier = Modifier,
    onClickVizIcon: () -> Unit = {}
){

    var userText by remember { mutableStateOf("") }

    TextField(
        value = userText,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = colorResource(R.color.textFildConteynerColor),
            focusedContainerColor = colorResource(R.color.textFildConteynerColor),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

        ),
        visualTransformation = if (!passwordViz) PasswordVisualTransformation() else VisualTransformation.None,
        onValueChange = {text ->
            userText = text
            onTextValueUser(text)
        },

        placeholder = {
            placeholder?.let {
                Text(
                    text = it,
                    fontSize = 15.sp,
                    fontFamily = sfProDisplay
                )
            }
        },
        trailingIcon = {
           if (passwordTextInput){
               IconButton(
                   onClick = {
                       onClickVizIcon()
                   }
               ) {
                   Icon(
                       painter = if (passwordViz) painterResource(R.drawable.passwordviz)
                       else painterResource(R.drawable.passwordinviz),
                       contentDescription = ""
                   )
               }
           }
        }
    )
}