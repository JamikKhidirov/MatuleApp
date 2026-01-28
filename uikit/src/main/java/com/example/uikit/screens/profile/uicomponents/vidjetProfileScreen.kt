package com.example.uikit.screens.profile.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R


@Preview(showBackground = true)
@Composable
fun vidjetProfileScreen(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.order,
    text: String = "Мои заказы",
    onClick: () -> Unit = {},
    swithch: (@Composable () -> Unit)? = null
){

    val incrementSouurse = remember {
        MutableInteractionSource()
    }


    Row(
        modifier = modifier
            .height(64.dp)
            .clickable(
                interactionSource = incrementSouurse,
                enabled = if (swithch == null) true else false,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(
                icon
            ),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )

        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start =  20.dp)
            )

        swithch?.invoke()
    }
}