package com.example.uikit.screencomponents.snackbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import okio.CipherSink


@Composable
@Preview
fun CastomErrorSnackbar(
    message: String = "Произошла ошибка",
    onIconClick: () -> Unit = {}
){
    Snackbar(
        containerColor = Color(0xFFFFFFFF)
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = message,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            IconButton(
                onClick = onIconClick,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .alpha(0.5f)
                    .background(Color(0xFF2074F2))


            ) {
                Icon(
                    painter = painterResource(R.drawable.iconx),
                    contentDescription = null
                )
            }
        }
    }
}