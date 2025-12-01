package com.example.uikit.screencomponents.appbars

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.screencomponents.appbars.barsdata.BarsItem


@Composable
@Preview(showBackground = true)
fun bottomNavigationBars(
    modifier: Modifier = Modifier,
    onClick: (index: Int) -> Unit = {}
){

    val items: List<BarsItem> = listOf(
        BarsItem(
            icon = painterResource(R.drawable.homevector),
            text = "Главная"
            ),
        BarsItem(
            icon = painterResource(R.drawable.katalogvector),
            text = "Каталог"
        ),
        BarsItem(
            icon = painterResource(R.drawable.projectvector),
            text = "Проекты"
        ),
        BarsItem(
            icon = painterResource(R.drawable.profilevector),
            text = "Профиль"
        )

    )

    var currentindex: Int by remember { mutableStateOf(0) }

    NavigationBar(
        modifier = modifier,
        containerColor = Color.White,
    ) {

       items.forEachIndexed { index, item ->
           NavigationBarItem(
               selected = index == index,
               colors =  NavigationBarItemDefaults.colors(
                   selectedTextColor = colorResource(R.color.textBtnColor),
                   selectedIconColor = colorResource(R.color.textBtnColor),
                   indicatorColor = Color.White

               ),
               onClick = {
                   currentindex = index
                   onClick(index)
               },
               icon = {
                   Icon(
                       painter = item.icon,
                       contentDescription = null,
                       modifier = Modifier.size(32.dp),
                       tint = if (index == currentindex) colorResource(R.color.textBtnColor) else Color(0xFFB8C1CC)
                   )
               },
               label = {
                   Text(
                       text = item.text,
                       fontSize = 12.sp,
                       color = if (index == currentindex) colorResource(R.color.textBtnColor) else Color(0xFFB8C1CC)
                   )
               }
           )
       }
    }


}