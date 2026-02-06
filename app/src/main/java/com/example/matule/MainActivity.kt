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
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.domain.AuthRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.firstOrNull
import navigation.AppNavGraph
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authDataStore: AuthRepository


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


        launcher.launch(
            Manifest.permission.CAMERA
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }







        setContent {
            val navcontroller = rememberNavController()

            val authToken by authDataStore.authTokenFlow.collectAsStateWithLifecycle(initialValue = null)

            AppNavGraph(
                isLogInUser = authToken != null,
                navController = navcontroller
            )
        }
    }
}



