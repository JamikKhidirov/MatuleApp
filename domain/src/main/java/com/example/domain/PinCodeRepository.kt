package com.example.domain

import kotlinx.coroutines.flow.Flow

interface PinCodeRepository {


    suspend fun saveData(data: String)

    suspend fun clearDataDataStore()

    val codeFlow: Flow<String?>
}