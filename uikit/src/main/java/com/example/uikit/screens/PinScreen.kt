package com.example.uikit.screens




import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.screencomponents.buttons.PinDigitButton
import com.example.uikit.screencomponents.indicators.PinIndicator


@Composable
@Preview(showBackground = true)
fun PinScreen(onPinEntered: (String) -> Unit = {}) {
    val pinLength = 4 // Требуемая длина PIN-кода

    // Состояние, хранящее введенный PIN-код
    var enteredPin by remember { mutableStateOf("") }

    // Лямбда-функция для обработки нажатия цифры
    val onNumberClick: (String) -> Unit = { digit ->
        if (enteredPin.length < pinLength) {
            enteredPin += digit
            if (enteredPin.length == pinLength) {
                // Если PIN-код введен полностью
                onPinEntered(enteredPin)
                // Очистка PIN-кода может быть добавлена здесь
                // enteredPin = ""
            }
        }
    }

    // Лямбда-функция для стирания последнего символа
    val onDeleteClick: () -> Unit = {
        if (enteredPin.isNotEmpty()) {
            enteredPin = enteredPin.dropLast(1)
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Заголовок и Индикатор
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Введите 4-значный код",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 32.dp)
                )
                PinIndicator(
                    pinLength = pinLength,
                    enteredLength = enteredPin.length,
                    modifier = Modifier.padding(bottom = 64.dp)
                )
            }

            // Клавиатура
            // Кнопки от 1 до 9 (3 ряда по 3 кнопки)
            Column(
                modifier = Modifier.fillMaxWidth(0.8f), // Ограничиваем ширину
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Ряды 1-3
                for (i in 0..2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        for (j in 1..3) {
                            val digit = (i * 3 + j).toString()
                            PinDigitButton(
                                digit = digit,
                                onClick = onNumberClick,
                                modifier = Modifier.size(80.dp)
                            )
                        }
                    }
                }

                // Нижний ряд (0, Пусто, Стереть)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    // Пустая "заглушка" для выравнивания
                    Spacer(modifier = Modifier.weight(1f))

                    // Кнопка 0 (посередине)
                    PinDigitButton(
                        digit = "0",
                        onClick = onNumberClick,
                        modifier = Modifier.size(80.dp)
                    )

                    // Кнопка "Стереть" (справа)
                    PinDigitButton(
                        digit = "delete", // Используем другое значение для идентификации
                        onClick = { onDeleteClick() },
                        modifier = Modifier.size(80.dp),
                        content = {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Стереть",
                                tint = Color.Black
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(1.dp)) // Небольшой отступ внизу
        }
    }
}