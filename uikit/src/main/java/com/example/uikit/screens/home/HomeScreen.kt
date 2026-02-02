package com.example.uikit.screens.home


import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.network.data.shopdata.News
import com.example.uikit.screencomponents.appbars.CardTabBar
import com.example.uikit.screencomponents.appbars.bottomNavigationBars
import com.example.uikit.screencomponents.searchbar.searchbar
import com.example.uikit.screencomponents.text.TextDescription
import com.example.uikit.screens.home.uicomponents.CatalogItemTitile
import com.example.uikit.screens.home.uicomponents.NewsRow
import com.example.uikit.screens.home.uicomponents.NewsVidjet


@Composable
fun HomeScreen(){


    var tabIndex by remember { mutableStateOf(0) }
    var indexScreen: Int by remember { mutableStateOf(0) }



    Scaffold(
        modifier = Modifier.fillMaxSize()
            .statusBarsPadding(),
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
            },
            list = listOf(

            )
        )
    }
}

@Composable
fun BottomHomeScreen(
    paddingValues: PaddingValues,
    onSelectedTab: (index: Int) -> Unit,
    list: List<News>
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
                    .padding(horizontal = 20.dp)
                    .padding(top = 24.dp)
            ) {  }
        }


        CatalogItemTitile(
            text = "Акции и новости",
            modifier = Modifier.padding(
                start = 20.dp,
                top = 30.dp)
        )

        item {
            var colorBrush = listOf(
                Color(0xFF97D9F0),
                Color(0xFF92E9D4)
            )
            NewsRow(
                newsList = list,
                modifier = Modifier
                    .padding(top = 16.dp),
                backGroundColorBrush = Brush.linearGradient(
                    colors = colorBrush
                )
            )
        }

        
        CatalogItemTitile(
            modifier = Modifier.padding(start = 20.dp)
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
                    .padding(top = 15.dp)
            )
        }


        item {
            //Здесь список каталогов и описаний тоесть товаров
            //Лучше сделать через items
        }


    }



}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}