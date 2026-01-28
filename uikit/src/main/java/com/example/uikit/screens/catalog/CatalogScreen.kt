package com.example.uikit.screens.catalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview


@Composable
@Preview(showBackground = true)
fun CatalogScreen(){

    Scaffold(
        modifier = Modifier.fillMaxSize()
            .statusBarsPadding()
    ) { allPadding ->
        BottomCatalogScreen(
            paddingValues = allPadding
        )
    }
}


@Composable
fun BottomCatalogScreen(
    paddingValues: PaddingValues
){
    Column(
        modifier = Modifier.padding(paddingValues)
    ) {

    }
}