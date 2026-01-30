package com.example.uikit.screens.catalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.screencomponents.appbars.CardTabBar
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
    paddingValues: PaddingValues,
    onSelectedTab : (tab: Int) -> Unit = {}
){
    val tabs = listOf("Все", "Мужчинам", "Женщинам", "Детям", "Аксесуары")
    var selectedTabIndex by remember { mutableStateOf(0) }


    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues)
    ){

       item {
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

       item {
           CardTabBar(
               options = tabs,
               selectedIndex = selectedTabIndex,
               onSelect = { indexTab ->
                   selectedTabIndex = indexTab
                   onSelectedTab(indexTab)
               },
               modifier = Modifier.fillMaxWidth()
                   .padding(top = 32.dp)
           )
       }
    }
}