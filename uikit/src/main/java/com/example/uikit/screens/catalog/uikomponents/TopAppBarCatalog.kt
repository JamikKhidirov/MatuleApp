package com.example.uikit.screens.catalog.uikomponents


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.data.R
import com.example.uikit.R.drawable.usericonprofile
import com.example.uikit.screencomponents.searchbar.searchbar


@Composable
@Preview(showBackground = true)
fun TopAppBarCatalog(
    modifier: Modifier = Modifier,
    valueSearchBar: String = "",
    onClickIconProfile: () -> Unit = {},
    onClickIxSerch: () -> Unit = {},
    onSearchInfo: (String) -> Unit = {}

){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        searchbar(
            value = valueSearchBar,
            modifier = Modifier
                .padding(end = 20.dp),
            onSearchInfo = onSearchInfo,
            onClickIxSerch = onClickIxSerch

        )

        IconButton(
            onClick = onClickIconProfile,
        ) {
            Icon(
                painter = painterResource(usericonprofile),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)


            )
        }
    }
}