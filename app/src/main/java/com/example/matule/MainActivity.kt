package com.example.matule

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import navigation.AppNavGraph


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    val launcher = registerForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ){ permission ->
        if (permission){
            //Разрешение выданы
        }


        else{

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        actionBar?.hide()


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
        launcher.launch(
            Manifest.permission.CAMERA
        )


        setContent {
            val navcontroller = rememberNavController()
            AppNavGraph(
                isLogInUser = false,
                navController = navcontroller
            )
        }
    }
}



