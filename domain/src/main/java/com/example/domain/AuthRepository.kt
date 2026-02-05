package com.example.domain

import com.sun.tools.javac.comp.Flow


interface AuthRepository {

    suspend fun saveAuthToken(token: String)
    suspend fun saveIdToken(idToken: String)
    suspend fun clearAuthTokens()

}