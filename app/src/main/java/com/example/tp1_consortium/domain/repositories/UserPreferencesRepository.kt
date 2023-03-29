package com.example.tp1_consortium.domain.repositories

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.tp1_consortium.core.Constants.dataStore
import com.example.tp1_consortium.domain.models.Trader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class UserPreferencesRepository(private val context:Context) {

    object PreferencesKeys {
        val USERNAME = stringPreferencesKey("username")

        val QUANTITY_ELEMENT_JA = floatPreferencesKey("element_ja")
        val QUANTITY_ELEMENT_KR = floatPreferencesKey("element_kr")
        val QUANTITY_ELEMENT_XU = floatPreferencesKey("element_xu")
        val QUANTITY_ELEMENT_YE = floatPreferencesKey("element_ye")
        val QUANTITY_ELEMENT_ZU = floatPreferencesKey("element_zu")



        }

    val traderPreferences = context.dataStore.data.map {
        val name = it[PreferencesKeys.USERNAME] ?: ""
        val quantityElementJa = it[PreferencesKeys.QUANTITY_ELEMENT_JA] ?:200.0
        val quantityElementKr = it[PreferencesKeys.QUANTITY_ELEMENT_KR] ?:200.0
        val quantityElementXu = it[PreferencesKeys.QUANTITY_ELEMENT_XU] ?:200.0
        val quantityElementYe = it[PreferencesKeys.QUANTITY_ELEMENT_YE] ?:200.0
        val quantityElementZu = it[PreferencesKeys.QUANTITY_ELEMENT_ZU] ?:200.0
        return@map Trader(name,quantityElementJa.toFloat(),quantityElementKr.toFloat(),quantityElementXu.toFloat(),quantityElementYe.toFloat(),quantityElementZu.toFloat())
    }

    suspend fun saveName(name: String) {
        context.dataStore.edit {
            it[PreferencesKeys.USERNAME] = name
        }
    }

    suspend fun saveRessources(jasmalt: Float,kreotrium: Float, xuskian: Float, yefrium: Float, zuscum: Float) {
        context.dataStore.edit {
            it[PreferencesKeys.QUANTITY_ELEMENT_JA] = jasmalt
            it[PreferencesKeys.QUANTITY_ELEMENT_KR] = kreotrium
            it[PreferencesKeys.QUANTITY_ELEMENT_XU] = xuskian
            it[PreferencesKeys.QUANTITY_ELEMENT_YE] = yefrium
            it[PreferencesKeys.QUANTITY_ELEMENT_ZU] = zuscum


        }
    }
}