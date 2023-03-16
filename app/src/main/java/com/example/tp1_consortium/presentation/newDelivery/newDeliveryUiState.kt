package com.example.tp1_consortium.presentation.newDelivery

sealed class newDeliveryUiState {

    object Empty : newDeliveryUiState()
    class Success(): newDeliveryUiState()
    class Error(val exception: Exception) : newDeliveryUiState()
}