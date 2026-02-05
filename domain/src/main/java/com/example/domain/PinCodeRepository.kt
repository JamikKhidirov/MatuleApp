package com.example.domain

interface PinCodeRepository {


    suspend fun saveData(data: String)

    suspend fun clearDataDataStore()
}