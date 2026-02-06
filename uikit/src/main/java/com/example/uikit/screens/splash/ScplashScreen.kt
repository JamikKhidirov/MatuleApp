package com.example.uikit.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uikit.theme.sfProDisplay
import kotlinx.coroutines.delay
import navigation.destinations.AuthDestination
import navigation.destinations.HomeDestination
import navigation.destinations.SplashScreenDestination

@Composable
fun SplashScreen(
    isLogInUser: Boolean,
    navController: NavController
) {
    LaunchedEffect(isLogInUser) {
        delay(1000)
        val destination = if (isLogInUser) {
            HomeDestination.getHomeRoom()
        } else {
            AuthDestination.getStartRoute()
        }
        navController.navigate(destination) {
            popUpTo(SplashScreenDestination) { inclusive = true }  // Удаляем сплеш из стека
            launchSingleTop = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2074F2)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Matule",
            fontSize = 40.sp,
            color = Color.White,
            fontFamily = sfProDisplay
        )
    }
}
