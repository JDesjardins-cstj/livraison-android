package com.example.tp1_consortium.presentation.newDelivery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp1_consortium.core.AppDatabase
import com.example.tp1_consortium.domain.models.Trader
import com.example.tp1_consortium.domain.repositories.TraderPreferencesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewDeliveryViewModel(application : Application) : AndroidViewModel(application) {
    private val newDeliveryRepository = AppDatabase.getInstance(application).delireryRepository()
    private val traderPreferencesRepository = TraderPreferencesRepository(application)
    private val _newDeliveryUiState = MutableStateFlow<NewDeliveryUiState>(NewDeliveryUiState.Empty)
    val newDeliveryUiState = _newDeliveryUiState.asStateFlow()

    init {
        var preferences = Trader()

        viewModelScope.launch {
            traderPreferencesRepository.traderPreferences.collect {
                preferences = it
                _newDeliveryUiState.update {
                    return@update NewDeliveryUiState.Success(preferences)

                }
            }
        }
    }
    //TODO: faire la function saveNote
    //fun saveDelivery()
}