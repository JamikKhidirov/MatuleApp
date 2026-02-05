package com.example.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


private val Context.dataStore by preferencesDataStore("authPrefs")


@Singleton
class TokenDataStore @Inject constructor(
    @ApplicationContext private val context: Context,

): AuthRepository{
    companion object {
        val TOKEN_KEY = stringPreferencesKey("auth_token")
        val ID_TOKEN = stringPreferencesKey("id_token")
    }

    override val authTokenFlow: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[TOKEN_KEY]
    }.catch {
        emit(null)
    }


    val idTokenFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[ID_TOKEN]
        }

    override suspend fun saveAuthToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
        }
    }


   override suspend fun saveIdToken(id: String) {
        context.dataStore.edit {  preferences ->
            preferences[ID_TOKEN] = id
        }
    }

    override suspend fun clearAuthTokens() {
        context.dataStore.edit {preferences ->
            preferences.remove(TOKEN_KEY)
        }
    }


    suspend fun clearIdToken(){
        context.dataStore.edit { preferences ->
            preferences.remove(ID_TOKEN)
        }
    }



}

