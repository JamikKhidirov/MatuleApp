package com.example.uikit.screencomponents.vidjets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.network.data.shopdata.Product
import com.example.uikit.R
import com.example.uikit.screencomponents.buttons.ButtonAdd
import kotlinx.coroutines.delay


@Composable
@Preview(showBackground = true)
fun ProductCard(
    productName: String = "Рубашка воскресение для машинного вязания",
    productDescription: String = "Мужская одежда",
    price: String = "300",
    onClickCard: () -> Unit = {},
    onClickAddButtom: () -> Unit = {}
){
    var isAdd = remember { mutableStateOf(true) }

    var lod = remember { mutableStateOf(false) }
    var isload = remember { mutableStateOf(false) }

    LaunchedEffect(lod) {
        delay(2000)
        if (isload.value == true){
            isload.value = false
        }
    }

    Card(
        modifier = Modifier
            .width(335.dp)
            .height(136.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = onClickCard,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            //Название продукта
            Text(
                text = productName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    //Описание продукта (какой это продукт)
                    Text(
                        text = productDescription,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.productDescColor)
                    )
                    //Цена продукта
                    Text(
                        text = price + " ₽",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                ButtonAdd(
                    isAdd = isAdd.value,
                    modifier = Modifier,
                    loading = isload.value
                ){
                    onClickAddButtom()
                    isAdd.value = !isAdd.value
                    lod.value = !lod.value
                    isload.value = true
                }
            }
        }
    }
}