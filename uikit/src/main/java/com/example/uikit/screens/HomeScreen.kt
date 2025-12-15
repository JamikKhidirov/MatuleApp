package com.example.uikit.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.screencomponents.appbars.CardTabBar
import com.example.uikit.screencomponents.appbars.bottomNavigationBars


@Composable
@Preview(showBackground = true)
fun HomeScreen(){


    var tabIndex by remember { mutableStateOf(0) }
    var indexScreen: Int by remember { mutableStateOf(0) }



    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
           Column {
               Divider(
                   color = Color(0xFFA0A0A04D),
               )
               bottomNavigationBars(
                   modifier = Modifier.fillMaxWidth(),
                   onClick = {index: Int ->
                       indexScreen = index
                   }
               )
           }
        }
    ) {
        paddingValues ->
        BottomHomeScreen(
            paddingValues = paddingValues,
            onSelectedTab = { selectTabIndex ->
                tabIndex = selectTabIndex
            }
        )
    }
}

@Composable
fun BottomHomeScreen(
    paddingValues: PaddingValues,
    onSelectedTab: (index: Int) -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val tabs = listOf("Все", "Мужчинам", "Женщинам", "Детям", "Аксесуары")
        var selectedTabIndex by remember { mutableStateOf(0) }

        CardTabBar(
            options = tabs,
            selectedIndex = selectedTabIndex,
            onSelect = { indexTab ->
                selectedTabIndex = indexTab
                onSelectedTab(indexTab)
            },
            modifier = Modifier.fillMaxWidth()


        )
    }
}