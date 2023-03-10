package com.example.tp1_consortium.presentation.Accueil

import com.example.tp1_consortium.domain.models.Trader

sealed class AccueilUiState {
    object Empty : AccueilUiState()
    object Loading : AccueilUiState()
    class Success(val planets: List<Trader>): AccueilUiState()
    class Error(val exception: Exception) : AccueilUiState()
}