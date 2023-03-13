package com.example.tp1_consortium.presentation.Accueil

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp1_consortium.domain.models.repositories.TraderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AccueilViewModel(application: Application): AndroidViewModel(application) {
    private val _accueilUiState = MutableStateFlow<AccueilUiState>(AccueilUiState.Empty)
    private val resoucesTrader = TraderRepository(application)
    val accueilUiState = _accueilUiState.asStateFlow()

    init {
        viewModelScope.launch {
            resoucesTrader =
        }
    }
}