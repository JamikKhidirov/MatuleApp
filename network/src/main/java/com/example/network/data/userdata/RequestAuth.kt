package com.example.network.data.userdata



data class RequestAuth(
    //Email пользователя
    val identity: String,
    //Пороль пользователя
    val password: String
)
