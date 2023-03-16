package com.example.tp1_consortium.presentation.delivery

import com.example.tp1_consortium.domain.models.Delivery
import com.example.tp1_consortium.domain.models.Trader

sealed class DeliveriesUiState {

    object Empty : DeliveriesUiState()
    class Success(val delivery: List<Delivery>): DeliveriesUiState()
    class Error(val exception: Exception) : DeliveriesUiState()
}