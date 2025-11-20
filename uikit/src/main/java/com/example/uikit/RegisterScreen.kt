package com.example.uikit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun RegisterScreen(){


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {paddingValues ->
        RegisterScreenBottom(paddingValues)
    }
}



@Composable
fun RegisterScreenBottom(paddingValues: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(paddingValues)){

        Row {  }
    }
}
