package com.example.uikit.screens.home.uicomponents



import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.screencomponents.text.TextDescription






fun LazyListScope.CatalogItemTitile(
    text: String = "Каталог описаний",
    fontSize: TextUnit = 18.sp,
    modifier: Modifier = Modifier,
){

    item {
        TextDescription(
            text = text,
            fontSize = fontSize,
            modifier = modifier
        )
    }


}