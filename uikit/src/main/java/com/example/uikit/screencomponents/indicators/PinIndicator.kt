package com.example.uikit.screencomponents.indicators

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview(showBackground = true)
fun PinIndicator(
    pinLength: Int = 4, // Общая длина PIN-кода (4)
    enteredLength: Int = 2, // Сколько цифр введено
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pinLength){ index ->
            val isFilled = index < enteredLength

            val color: Color by animateColorAsState(
                targetValue = if (isFilled) Color.Blue else Color.LightGray,
                animationSpec = tween(durationMillis = 200)
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}