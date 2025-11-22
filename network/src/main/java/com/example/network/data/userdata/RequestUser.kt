package com.example.network.data.userdata



data class RequestUser(
    val email: String,
    val emailVisibility: Boolean,
    val firstName: String,
    val lastName: String,
    val secondName: String,
    val datebirthday: String,
    val gender: String,
)
