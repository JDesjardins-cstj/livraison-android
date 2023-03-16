package com.example.tp1_consortium.presentation.delivery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp1_consortium.core.AppDatabase
import com.example.tp1_consortium.domain.models.Delivery
import com.example.tp1_consortium.domain.repositories.DeliveryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DeliveriesViewModel(application : Application) : AndroidViewModel(application) {
    private val deliveryRepository = AppDatabase.getInstance(application).delireryRepository()
    private val _DeliveriesUiState = MutableStateFlow<DeliveriesUiState>(DeliveriesUiState.Empty)
    val deliveriesUiState = _DeliveriesUiState.asStateFlow()
    init {
        var deliveries: List<Delivery> = listOf()
        viewModelScope.launch {
            deliveryRepository.retrieveAll().collect{
                deliveries = it
                _DeliveriesUiState.update {
                    return@update DeliveriesUiState.Success(deliveries)
            }

            }
        }
    }
}