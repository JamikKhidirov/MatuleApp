package com.example.network.data.backetdata



data class ResponseCart(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val user_id: String,
    val product_id: String,
    val count: Int
)
