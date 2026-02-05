package com.example.domain

interface DataStoreRepository {


    suspend fun saveData(data: String)

    suspend fun cleatDataDataStore()
}