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
                    binding.txvjasmaltNb.text = it.trader.jasmalt.toString()
                    binding.txvKreotriumNb.text = it.trader.kreotrium.toString()
                    binding.txvXuskianNb.text = it.trader.xuskian.toString()
                    binding.txvYefriumNb.text = it.trader.yefrium.toString()
                    binding.txvZuscumNb.text = it.trader.zuscum.toString()



                }
            }
        }.launchIn(lifecycleScope)

        binding.sldJasmalt.addOnChangeListener { _, value, _ ->  binding.txvjasmaltNb.text = String.format( "%.2f",value) }
        binding.sldKreotrium.addOnChangeListener { _, value, _ ->  binding.txvKreotriumNb.text = String.format( "%.2f",value) }
        binding.sldXuskian.addOnChangeListener { _, value, _ ->  binding.txvXuskianNb.text = String.format( "%.2f",value) }
        binding.sldYerium.addOnChangeListener { _, value, _ ->  binding.txvYefriumNb.text = String.format( "%.2f",value) }
        binding.sldZuscum.addOnChangeListener { _, value, _ ->  binding.txvZuscumNb.text = String.format( "%.2f",value) }

        binding.fabSave.setOnClickListener{
            val amountJasmalt = binding.sldJasmalt.value
            val amountKreotrium = binding.sldJasmalt.value
            val amountXuskian = binding.sldJasmalt.value
            val amountYefrium = binding.sldJasmalt.value
            val amountZuscum = binding.sldJasmalt.value

            viewModel.saveDelivery(amountJasmalt,amountKreotrium,amountXuskian,amountYefrium,amountZuscum)
        }

    }




    companion object {
        fun newIntent(context : Context) : Intent {
            return Intent(context, NewDeliveryActitity::class.java)
        }
    }
}