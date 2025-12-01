package com.example.matule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.matule.ui.theme.MatuleTheme
import com.example.uikit.screens.LogInScreenScreen
import dagger.hilt.android.AndroidEntryPoint
import navigation.AppNavGraph


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navcontroller = rememberNavController()
            AppNavGraph(
                navController = navcontroller
            )
        }
    }
}



