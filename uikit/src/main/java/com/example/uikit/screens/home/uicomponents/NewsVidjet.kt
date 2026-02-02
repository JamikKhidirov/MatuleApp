package com.example.uikit.screens.home.uicomponents

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.network.data.shopdata.News
import org.jetbrains.annotations.Async


@Composable
fun NewsVidjet(
    modifier: Modifier = Modifier,
    backgroundBrush: Brush,
    price: String,
    news: News
)
{

    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .background(backgroundBrush),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = news.collectionName,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = news.collectionId,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 5.dp),
                    fontWeight = FontWeight.Bold
                )

            }

            Text(
                text = "$price ₽",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(
                    top = 40.dp,
                ),
                fontWeight = FontWeight.Bold
            )
        }


        //Сюда изображsение нужно вставить через coil
        AsyncImage(
            model = news.newsImage,
            contentDescription = "Изображение новости",
            modifier = Modifier.padding(vertical = 16.dp)
                .padding(start = 20.dp, end = 10.dp)
                .size(150.dp),
        )
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
            newsImage = "https://example.com/image.jpg",
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