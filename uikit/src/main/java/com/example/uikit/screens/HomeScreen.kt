package com.example.uikit.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.screencomponents.appbars.bottomNavigationBars


@Composable
@Preview(showBackground = true)
fun HomeScreen(){


    var indexScreen: Int by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            bottomNavigationBars(
                modifier = Modifier.fillMaxWidth(),
                onClick = {index: Int ->
                    indexScreen = index
                }
            )
        }
    ) {
        paddingValues ->
        BottomHomeScreen(paddingValues)
    }
}

@Composable
fun BottomHomeScreen(
    paddingValues: PaddingValues
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues)
    ) {  }
}