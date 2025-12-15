package com.example.uikit.screencomponents.appbars

import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


@Composable
fun CardTabBar(
    options: List<String>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
    spaceBetween: Dp = 16.dp
) {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current
    val spacePx = with(density) { spaceBetween.toPx() }

    var parentWidth by remember { mutableStateOf(0) }

    // ширины элементов
    val itemWidths = remember(options) { MutableList(options.size) { 0 } }

    LazyRow(
        state = listState,
        modifier = modifier.onGloballyPositioned { parentWidth = it.size.width },
        horizontalArrangement = Arrangement.spacedBy(spaceBetween),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(options) { index, item ->
            CastomCardTab(
                text = item,
                selected = index == selectedIndex,
                modifier = Modifier.onGloballyPositioned { coords ->
                    itemWidths[index] = coords.size.width
                },
                onClick = {
                    onSelect(index)

                    scope.launch {
                        if (parentWidth == 0) return@launch
                        if (itemWidths.any { it == 0 }) return@launch

                        val selectedWidth = itemWidths[index]

                        // абсолютная позиция начала выбранного элемента
                        val itemStart = itemWidths.take(index).sum() + index * spacePx

                        // центр выбранного элемента
                        val itemCenter = itemStart + selectedWidth / 2f

                        // центр LazyRow
                        val rowCenter = parentWidth / 2f

                        // желаемый scroll position:
                        val desiredScroll = itemCenter - rowCenter

                        // максимальный скролл к концу контента
                        val fullContentWidth =
                            itemWidths.sum() + spacePx * (options.size - 1)

                        val maxScroll = fullContentWidth - parentWidth

                        // ===== ОГРАНИЧЕНИЕ =====
                        // если центрирование невозможно - НЕ СКРОЛЛИМ
                        val clampedScroll = desiredScroll.coerceIn(0f, maxScroll)

                        // текущая scroll позиция
                        val currentScroll = listState.firstVisibleItemScrollOffset +
                                listState.firstVisibleItemIndex * 0f // неважно, offset используем

                        val delta = clampedScroll - currentScroll

                        // если равны -> нечего делать
                        if (delta.absoluteValue < 1f) return@launch

                        listState.animateScrollBy(delta)
                    }
                }
            )
        }
    }
}
