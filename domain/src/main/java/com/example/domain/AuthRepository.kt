package com.example.domain

import kotlinx.coroutines.flow.Flow


interface AuthRepository {

    suspend fun saveAuthToken(token: String)
    suspend fun saveIdToken(idToken: String)
    suspend fun clearAuthTokens()

    val authTokenFlow: Flow<String?>
}