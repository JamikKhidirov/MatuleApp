package com.example.uikit.screencomponents.buttons


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R


@Composable
fun ButtonScreens(
    text: String = "Далее",
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    enableButton: Boolean = true,
    onClickButton: () -> Unit = {},
) {

    Button(
        onClick = onClickButton,
        modifier = modifier,
        enabled = enableButton,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.buttonColor),
            disabledContainerColor = colorResource(R.color.dizableConteinerButtonColor),
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(15.dp)
    ) {
        if (loading){
            CircularProgressIndicator(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center),
                color = Color.White,
                strokeWidth = 5.dp

            )
        }
        else{
            Text(
                text = text,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun prevButton(){
    ButtonScreens(
        modifier = Modifier.width(200.dp)
            .height(50.dp),
        loading = false,
        enableButton = true,
    ) {  }
}