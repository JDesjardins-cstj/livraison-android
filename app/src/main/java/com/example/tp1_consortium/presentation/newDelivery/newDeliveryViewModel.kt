package com.example.tp1_consortium.presentation.newDelivery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp1_consortium.core.AppDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class newDeliveryViewModel(application : Application) : AndroidViewModel(application) {
    private val livraisonRepository = AppDatabase.getInstance(application).delireryRepository()
    private val _livraisonsUiState = MutableStateFlow<newDeliveryUiState>(newDeliveryUiState.Empty)
    val livraisonUiState = _livraisonsUiState.asStateFlow()

    init {
        viewModelScope.launch {
            _livraisonsUiState.update {
                return@update newDeliveryUiState.Success()
            }
        }
    }
}