package com.example.uikit.screens.home.uicomponents

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.network.data.shopdata.News


@Composable
fun NewsVidjet(
    modifier: Modifier,
    backgroundBrush: Brush,
    price: String,
    news: News
)
{

    Row(
        modifier = modifier
            .background(backgroundBrush)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp)
        ) {
            Text(
                text = news.collectionName,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = news.collectionId,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp),
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$price ₽",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 40.dp)
            )
        }


        //Сюда изображение нужно вставить через coil
    }
}


@Composable
@Preview
fun NewsVidjetPreview(){


    NewsVidjet(
        modifier = Modifier,
        news = News(
            collectionId = "Вторник",
            collectionName = "Шорты",
            id = "1",
            newsImage = "https://via.placeholder.com/300",
            created = "1",
            updated = "1"
        ),
        price = "4000",
        backgroundBrush = Brush
            .linearGradient(
                colors  = listOf(
                    Color(0xFF97D9F0),
                    Color(0xFF92E9D4)
                )
            )
    )
}