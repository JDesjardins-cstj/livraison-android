package com.example.tp1_consortium.presentation.newDelivery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tp1_consortium.databinding.ActivityNewDeliveryBinding
import com.example.tp1_consortium.presentation.delivery.DeliveriesActivity
import com.example.tp1_consortium.presentation.delivery.DeliveriesUiState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NewDeliveryActitity : AppCompatActivity() {

    private lateinit var binding: ActivityNewDeliveryBinding
    private val viewModel : NewDeliveryViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.newDeliveryUiState.onEach {
            when(it)
            {
                NewDeliveryUiState.Empty -> Unit
                is NewDeliveryUiState.Error -> TODO()
                is NewDeliveryUiState.Success -> {
                    binding.sldJasmalt.valueTo = it.trader.jasmalt
                    binding.sldKreotrium.valueTo = it.trader.kreotrium
                    binding.sldXuskian.valueTo = it.trader.xuskian
                    binding.sldYerium.valueTo = it.trader.yefrium
                    binding.sldZuscum.valueTo = it.trader.zuscum


                }
            }
        }.launchIn(lifecycleScope)

        binding.sldYerium.addOnChangeListener { _, _, _ -> binding.sldYerium.value  }


    }


    companion object {
        fun newIntent(context : Context) : Intent {
            return Intent(context, NewDeliveryActitity::class.java)
        }
    }
}