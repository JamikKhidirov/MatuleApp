package com.example.network.data.orderdata



data class RequestOrder(
    val user_id: String,
    val product_id: String,
    val count: Int
)
