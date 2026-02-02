package com.example.uikit.screens.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.screencomponents.appbars.CardTabBar
import com.example.uikit.screencomponents.appbars.bottomNavigationBars
import com.example.uikit.screencomponents.searchbar.searchbar
import com.example.uikit.screencomponents.text.TextDescription
import com.example.uikit.screens.home.uicomponents.CatalogItemTitile


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
    ) { paddingValues ->
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

    val tabs = listOf("Все", "Мужчинам", "Женщинам", "Детям", "Аксесуары")
    var selectedTabIndex by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues)
    ) {


        item {
            searchbar(
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp)
            ) {  }
        }

        
        CatalogItemTitile(
            modifier = Modifier.padding(start = 20  .dp)
        )

        item {
            CardTabBar(
                options = tabs,
                selectedIndex = selectedTabIndex,
                onSelect = { indexTab ->
                    selectedTabIndex = indexTab
                    onSelectedTab(indexTab)
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 5.dp)
            )
        }

    }

}