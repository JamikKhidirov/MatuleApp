package com.example.uikit.screencomponents.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R



@Composable
@Preview
fun CounterButton(
    modifier: Modifier = Modifier,
    enabelBtnMinus: Boolean = true,
    onClickMinus: () -> Unit = {},
    onClickPlus: () -> Unit = {}
){
    Row(
        modifier = Modifier.clip(RoundedCornerShape(8.dp))
            .then(modifier).background(Color(0xFFF5F5F9)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onClickMinus,
            enabled = enabelBtnMinus
        ) {
            //Кнока для минуса товара
            Icon(
                painter = painterResource(R.drawable.iconsminus),
                contentDescription = null,
                tint = Color(0xFF939396)
            )
        }

        VerticalDivider(
            modifier = Modifier.height(16.dp),
            color = Color(0xFFEBEBEB)
        )

        IconButton(
            onClick = onClickPlus
        ) {
            //Кнока для минуса товара
            Icon(
                painter = painterResource(R.drawable.iconplus),
                contentDescription = null,
                tint = Color(0xFF939396)
            )
        }
    }
}