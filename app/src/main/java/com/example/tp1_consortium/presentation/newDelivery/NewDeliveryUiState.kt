package com.example.tp1_consortium.presentation.newDelivery

import com.example.tp1_consortium.domain.models.Trader

sealed class NewDeliveryUiState {

    object Empty : NewDeliveryUiState()
    class Success(val trader: Trader): NewDeliveryUiState()
    class Error(val exception: Exception) : NewDeliveryUiState()
}