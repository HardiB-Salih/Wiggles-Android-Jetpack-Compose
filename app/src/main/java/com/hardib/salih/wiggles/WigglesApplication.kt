package com.hardib.salih.wiggles

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

import androidx.datastore.preferences.core.booleanPreferencesKey

class WigglesApplication: Application() {

    companion object {
        private val isDark = booleanPreferencesKey("IS_DARK")
        private const val  SHARDED_PREF = "shared_pref"
        private const val DATA_STORE_REF = "data_store_ref"
    }

//    private  val dataStore: DataStore<Preferences> =

    override fun onCreate() {
        super.onCreate()

    }

}