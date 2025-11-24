package com.example.network.service

import com.example.network.data.orderdata.RequestOrder
import com.example.network.data.orderdata.ResponseOrder
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


//Интерфейс для действий с заказом
interface ApiOrderService {

    //Создание заказа
    @POST("collections/orders/records")
    suspend fun createOrder(@Body requestOrder: RequestOrder): Response<ResponseOrder>

}