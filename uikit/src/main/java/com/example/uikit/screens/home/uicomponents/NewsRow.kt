package com.example.uikit.screens.home.uicomponents



import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.network.data.shopdata.News


@Composable
fun NewsRow(
    modifier: Modifier = Modifier,
    backGroundColorBrush: Brush,
    newsList: List<News>
){
    LazyRow(
        modifier = modifier
    ) {
        itemsIndexed(newsList){ index, news ->
            val price: String = if (index == 0) "4000" else "8000"

            NewsVidjet(
                news = news,
                backgroundBrush = backGroundColorBrush,
                price = price
            )
        }
    }
}