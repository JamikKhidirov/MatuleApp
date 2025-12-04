package com.example.uikit.screencomponents.buttons

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R


@Composable
@Preview(showBackground = true)
fun ButtonAdd(
    isAdd: Boolean = false,
    modifier: Modifier = Modifier,
    loading: Boolean = true,
    onClick: () -> Unit = {}
){
    if (isAdd){
        ButtonScreens(
            text = "Добвить",
            shape = 10,
            modifier = modifier,
            loading = loading,
            onClickButton = onClick
        )
    }
    else{
        OutlinedButton(
            modifier = modifier,
            onClick = onClick,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
            ),
            border = BorderStroke(1.dp, colorResource(R.color.buttonColor))
        ){
            if (loading){
                CircularProgressIndicator(
                    color = colorResource(R.color.buttonColor),
                    strokeWidth = 5.dp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )

            }
            else{
                Text(
                    text = "Убрать",
                    fontSize = 14.sp,
                    color = colorResource(R.color.buttonColor),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}