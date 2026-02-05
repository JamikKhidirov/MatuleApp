package com.example.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.PinCodeRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton








@Singleton
class PincodeDataStore @Inject constructor(
    @ApplicationContext context: Context
): PinCodeRepository {

    private val Context.dataStore by preferencesDataStore("pincode")

    companion object {
        val CODE_KAY = stringPreferencesKey("pincode")
    }


    private val _dataStore = context.dataStore


    val codeFlow: Flow<String?> = _dataStore.data
        .map {preferences ->
            preferences[CODE_KAY]
        }.catch {
            emit(null)
        }



    override suspend fun saveData(data: String) {
        _dataStore.edit { preferences ->
            preferences[CODE_KAY] = data
        }
    }

    override suspend fun clearDataDataStore() {
        _dataStore.edit { preferences ->
            preferences.remove(CODE_KAY)
        }
    }

}

