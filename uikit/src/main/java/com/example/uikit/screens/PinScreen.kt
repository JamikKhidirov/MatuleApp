package com.example.uikit.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.difference
import com.example.uikit.R

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.screencomponents.buttons.PinDigitButton
import com.example.uikit.screencomponents.indicators.PinIndicator
import com.example.uikit.screencomponents.text.TextDescription


@Composable
@Preview(showBackground = true)
fun PinScreen(
    navController: NavController,
    firstTextScreen: String = "Cоздайте пороль",
    onPinEntered: (String) -> Unit = {}
) {

    val pinLength = 4
    var enteredPin by remember { mutableStateOf("") }

    fun onNumberClick(d: String) {
        if (enteredPin.length < pinLength) {
            enteredPin += d
            if (enteredPin.length == pinLength) onPinEntered(enteredPin)
        }
    }

    fun onDelete() {
        if (enteredPin.isNotEmpty()) enteredPin = enteredPin.dropLast(1)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Создайте пороль",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(top = 100.dp)
                )


                if (firstTextScreen == "Cоздайте пороль"){
                    TextDescription(
                        text = "Для защиты ваших персональных данных",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }


                PinIndicator(
                    pinLength = pinLength,
                    enteredLength = enteredPin.length,
                    modifier = Modifier.padding(top = 56.dp)
                )
            }

            // Клавиатура
            Column(
                modifier = Modifier.padding(top = 60.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                // Ряды 1–9
                for (row in 0..2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        for (col in 1..3) {
                            val digit = (row * 3 + col).toString()
                            PinDigitButton(digit, onClick = ::onNumberClick, content = null)
                        }
                    }
                }

                // Нижний ряд
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Spacer(modifier = Modifier.size(80.dp))

                    PinDigitButton("0", onClick = ::onNumberClick, content = null)

                    PinDigitButton(
                        digit = "delete",
                        isArrayBack = true,
                        onClick = { onDelete() },
                        content = {
                            Icon(
                                painter = painterResource(R.drawable.deleteicon),
                                contentDescription = "Delete",
                                tint = Color.Black

                            )
                        }
                    )
                }
            }
        }
    }
}
