package com.example.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.data.TokenDataStore.Companion.TOKEN_KEY
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton






private val Context.dataStore by preferencesDataStore("pincode")

@Singleton
class PincodeDataStore @Inject constructor(
    @ApplicationContext context: Context
) {



    companion object {
        val CODE_KAY = stringPreferencesKey("pincode")
    }


    private val _dataStore = context.dataStore


    val codeFlow: Flow<String?> = _dataStore.data
        .map {preferences ->
            preferences[CODE_KAY]
        }


    suspend fun saveToken(code: String) {
        _dataStore.edit { preferences ->
            preferences[CODE_KAY] = code
        }
    }


    suspend fun clearCode() {
        _dataStore.edit { preferences ->
            preferences.remove(CODE_KAY)
        }
    }
}

