package com.example.uikit.screens.catalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.screens.catalog.uikomponents.TopAppBarCatalog


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
        TopAppBarCatalog(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp),
            onClickIxSerch = {
                //Иконка очистки текста
            },
            onSearchInfo = {textSearch ->
                //Поиск в бд
            },
            onClickIconProfile = {
                //Навигация на экран профиля
            }
        )
    }
}