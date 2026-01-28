package com.example.uikit.screencomponents.buttons


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview(showBackground = true)
fun CastomCheckBox(
    modifier: Modifier = Modifier,
    check: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
){
    var check by remember { mutableStateOf(check) }

    Switch(
        checked = check,
        onCheckedChange = {valueCheck ->
            check = valueCheck
            onCheckedChange(valueCheck)
        },
        modifier = modifier,
        colors = SwitchDefaults.colors(
            checkedBorderColor = Color.Transparent,
            uncheckedBorderColor = Color.Transparent,
            checkedThumbColor = Color.White,
            uncheckedThumbColor = Color.White,
            checkedTrackColor = Color(0xFF1A6FEE),
            uncheckedTrackColor = Color(0xFFEBEBEB)
        ),
        thumbContent = {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
                    .shadow(20.dp)
                    .background(Color.White)
            )
        }
    )
}