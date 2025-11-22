package com.example.network.data.userdata

data class RequestRegister(
    val email: String,
    val password: String,
    val passwordConfirm: String
)