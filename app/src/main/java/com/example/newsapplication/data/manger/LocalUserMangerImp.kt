package com.example.newsapplication.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsapplication.Constants
import com.example.newsapplication.Constants.USER_SETTINGS
import com.example.newsapplication.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserMangerImp(
   private val context: Context
):LocalUserManger {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings->
            settings[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
       return context.dataStore.data.map { preferences->
           preferences[PreferencesKey.APP_ENTRY]?:false
       }
    }
}

private val Context.dataStore :DataStore<Preferences> by  preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKey{
    val APP_ENTRY  = booleanPreferencesKey(Constants.APP_ENTRY)

}