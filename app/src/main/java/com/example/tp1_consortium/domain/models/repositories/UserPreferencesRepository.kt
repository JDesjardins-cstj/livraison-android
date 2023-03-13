package com.example.tp1_consortium.domain.models.repositories

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

class UserPreferencesRepository(private  val context:Context) {

    object PreferencesKeys {
        val USERNAME = stringPreferencesKey("username")

        val QUANTITY_ELEMENT_JA = floatPreferencesKey("element_ja")
        val QUANTITY_ELEMENT_KR = floatPreferencesKey("element_kr")
        val QUANTITY_ELEMENT_XU = floatPreferencesKey("element_xu")
        val QUANTITY_ELEMENT_YE = floatPreferencesKey("element_ye")
        val QUANTITY_ELEMENT_ZU = floatPreferencesKey("element_zu")



        }

    val userPreferences = context.dataStore.data.map {
        val name = it[PreferencesKeys.USERNAME] ?: ""
        return@map UserPreferences(name)
    }

    suspend fun saveName(name: String) {
        context.dataStore.edit {
            it[PreferencesKeys.USERNAME] = name
        }
    }
}