package com.example.network.data.shopdata



data class Product(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val title: String,
    val description: String,
    val price: Int,
    val typeCloses: String,
    val type: String,
    val approximateCost: String
)
