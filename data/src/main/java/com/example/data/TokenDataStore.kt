package com.example.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.DataStoreRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


private val Context.dataStore by preferencesDataStore("authPrefs")


@Singleton
class TokenDataStore @Inject constructor(
    @ApplicationContext private val context: Context
): DataStoreRepository{
    companion object {
        val TOKEN_KEY = stringPreferencesKey("auth_token")
        val ID_TOKEN = stringPreferencesKey("id_token")
    }

    val tokenFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[TOKEN_KEY]
        }

    val idTokenFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[ID_TOKEN]
        }



    suspend fun saveIdToken(id: String) {
        context.dataStore.edit {  preferences ->
            preferences[ID_TOKEN] = id
        }
    }



    suspend fun clearIdToken(){
        context.dataStore.edit { preferences ->
            preferences.remove(ID_TOKEN)
        }
    }

    override suspend fun saveData(data: String) {
        context.dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = data
        }
    }

    override suspend fun cleatDataDataStore() {
        context.dataStore.edit { preferences ->
            preferences.remove(TOKEN_KEY)
        }
    }

}

