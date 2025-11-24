package com.example.uikit.screencomponents.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
fun PinDigitButton(
    digit: String = "1",
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {
        Text(
            text = digit,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
){

    // 1. Источник взаимодействия: отслеживает нажатия, удержания и т.д.
    val interactionSource = remember { MutableInteractionSource() }

    // 2. Проверяем, нажата ли кнопка прямо сейчас
    val isPressed by interactionSource.collectIsPressedAsState()

    // 3. Анимируем цвет фона
    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) Color.Blue.copy(alpha = 0.7f) else Color.LightGray.copy(alpha = 0.3f),
        animationSpec = tween(durationMillis = 150) // Быстрая и плавная анимация
    )

    Button(
        onClick = { onClick(digit) },
        modifier = modifier
            .size(80.dp)// Делаем квадратным, чтобы обеспечить идеальный круг
            .clip(CircleShape),
        shape = CircleShape, // Круглая кнопка
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.Black
        ),
        interactionSource = interactionSource, // Применяем наш источник взаимодействия
        elevation = null,
        contentPadding = PaddingValues(0.dp)
    ) {
        content()
    }

}