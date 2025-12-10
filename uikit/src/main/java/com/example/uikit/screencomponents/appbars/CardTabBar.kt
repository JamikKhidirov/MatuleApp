package com.example.uikit.screencomponents.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CardTabBar(
    options: List<String>,
    selectedIndex: Int,
    onSelect: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    spaceBetween: Dp = 16.dp
){
    LazyRow(
        modifier = modifier
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(spaceBetween),
        verticalAlignment = Alignment.CenterVertically
    ){
        itemsIndexed(options){ index, item ->
            CastomCardTab(
                text = item,
                selected = index == selectedIndex,
                onClick = {
                    onSelect(index)
                }
            )
        }
    }
}