package com.example.uikit.screencomponents.appbars


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import java.nio.file.WatchEvent


@Composable
@Preview(showBackground = true)
fun CastomCardTab(
    text: String = "Мужчинам",
    selected: Boolean = true,
    modifier: Modifier = Modifier,
    selectedBackGrounColor: Color = colorResource(R.color.textBtnColor),
    onClick: () -> Unit = {}
){
    val bacgroundColor by animateColorAsState(
        targetValue = if (selected) selectedBackGrounColor else
            colorResource(R.color.castomTabbacgroundColor)
    )

    val contentColor by animateColorAsState(
        targetValue = if (selected) Color.White else
            colorResource(R.color.castomTabContentColor)
    )


    Card(
        modifier = modifier.height(48.dp)
            .width(120.dp)
            .wrapContentWidth(),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = bacgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Box(
            modifier = Modifier.padding(
                vertical = 14.dp,
                horizontal = 20.dp
            ).fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = text,
                color = contentColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}