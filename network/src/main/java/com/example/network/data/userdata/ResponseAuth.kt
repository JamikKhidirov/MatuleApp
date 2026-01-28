package com.example.network.data.userdata



data class ResponseAuth(
    val user: User,
    val token: String
)




//Для мок сервера авторизации
//Мок сервер - тестовый сервер
data class ResponseAuthMock(
    val token: String,
    val record: ResponseUserMock
)


//User для мок сервера авторизации
data class ResponseUserMock(
    val id: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val verified: String,
    val datebirthday: String
)