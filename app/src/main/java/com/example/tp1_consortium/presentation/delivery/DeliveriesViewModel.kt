package com.example.tp1_consortium.presentation.delivery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp1_consortium.domain.models.Trader
import com.example.tp1_consortium.presentation.Accueil.AccueilUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DeliveriesViewModel(application : Application) : AndroidViewModel(application) {
    private val _DeliveriesUiState = MutableStateFlow<DeliveriesUiState>(DeliveriesUiState.Empty)
    val deliveriesUiState = _DeliveriesUiState.asStateFlow()
    init {

    }
}