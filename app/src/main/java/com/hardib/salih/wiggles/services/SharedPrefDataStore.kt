package com.hardib.salih.wiggles.services

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SharedPrefDataStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("preferences_Data_Store")
        val IS_DARK = booleanPreferencesKey("is_dark")
    }

    val getIsDark : Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[IS_DARK] ?: false
        }

    suspend fun saveTheme(isDark: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_DARK] = isDark
        }
    }

}