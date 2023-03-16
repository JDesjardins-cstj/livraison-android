package com.example.tp1_consortium.presentation.delivery

import com.example.tp1_consortium.domain.models.Trader

sealed class DeliveriesUiState {

    object Empty : DeliveriesUiState()
    class Success(val trader: Trader): DeliveriesUiState()
    class Error(val exception: Exception) : DeliveriesUiState()
}