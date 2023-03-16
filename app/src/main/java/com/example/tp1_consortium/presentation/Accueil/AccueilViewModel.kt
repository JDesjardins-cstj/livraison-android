package com.example.tp1_consortium.presentation.Accueil

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp1_consortium.domain.models.models.Delivery
import com.example.tp1_consortium.domain.models.models.Trader
import com.example.tp1_consortium.domain.models.repositories.TraderRepository
import com.example.tp1_consortium.domain.models.repositories.UserPreferencesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AccueilViewModel(application: Application): AndroidViewModel(application) {
    private val _accueilUiState = MutableStateFlow<AccueilUiState>(AccueilUiState.Empty)
    private val userPreferencesRepository = UserPreferencesRepository(application)
    val accueilUiState = _accueilUiState.asStateFlow()


    init {

        var preferences = Trader()

        viewModelScope.launch {
            userPreferencesRepository.traderPreferences.collect {
                preferences = it
                _accueilUiState.update {
                    return@update AccueilUiState.Success(preferences)
                }
            }
        }






    }
    fun saveName(name: String) {
        viewModelScope.launch {
            userPreferencesRepository.saveName(name)
        }
    }

    fun saveRessources(jasmalt: Float,kreotrium: Float, xuskian: Float, yefrium: Float, zuscum: Float )
    {
        viewModelScope.launch {
            userPreferencesRepository.saveRessources(jasmalt,kreotrium,xuskian,yefrium,zuscum)
        }
    }
}