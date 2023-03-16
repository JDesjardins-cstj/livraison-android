package com.example.tp1_consortium.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object Constants {
    const val IMAGE_URL = "https://assets.andromia.science/planets/%s.png"

    val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "tp1-datastore")

    object BaseUrl {
        private const val BASE_API = "https://api.andromia.science"
        const val PLANETS = "$BASE_API/planets"
    }
}