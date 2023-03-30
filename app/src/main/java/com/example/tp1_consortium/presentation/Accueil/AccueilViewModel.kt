package com.example.tp1_consortium.presentation.Accueil

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

class AccueilViewModel(application: Application): AndroidViewModel(application) {
    private val _accueilUiState = MutableStateFlow<AccueilUiState>(AccueilUiState.Empty)
    private val traderPreferencesRepository = TraderPreferencesRepository(application)
    private val deliveryRepository = AppDatabase.getInstance(application).delireryRepository()
    val accueilUiState = _accueilUiState.asStateFlow()


    init {

        var preferences = Trader()

        viewModelScope.launch {
            traderPreferencesRepository.traderPreferences.collect {
                preferences = it
                _accueilUiState.update {
                    return@update AccueilUiState.Success(preferences)
                }
            }
        }
    }
    fun saveName(name: String) {
        viewModelScope.launch {
            traderPreferencesRepository.saveName(name)
        }
    }

    fun recharger(jasmalt: Float,kreotrium: Float, xuskian: Float, yefrium: Float, zuscum: Float )
    {
        viewModelScope.launch {
            traderPreferencesRepository.recharge(jasmalt,kreotrium,xuskian,yefrium,zuscum)
        }
    }

    fun saveRessources(jasmalt: Float,kreotrium: Float, xuskian: Float, yefrium: Float, zuscum: Float )
    {
        viewModelScope.launch {
            traderPreferencesRepository.saveRessources(jasmalt,kreotrium,xuskian,yefrium,zuscum)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            deliveryRepository.deleteAll()
        }
    }
}