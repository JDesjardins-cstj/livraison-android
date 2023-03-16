package com.example.tp1_consortium.presentation.delivery

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tp1_consortium.R
import com.example.tp1_consortium.databinding.ActivityDeliveriesBinding
import com.example.tp1_consortium.presentation.Accueil.AccueilUiState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DeliveriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeliveriesBinding
    private val viewModel : DeliveriesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.deliveriesUiState.onEach {
            when(it){
                DeliveriesUiState.Empty -> Unit
                is DeliveriesUiState.Error -> TODO()
                is DeliveriesUiState.Success -> {
                    val nom =  "bon retour " + it.trader.name
                    binding.txvbonRetour.setText("aaa")
                 }
            }
        }.launchIn(lifecycleScope)
    }


    companion object {
        fun newIntent(context : Context) : Intent {
            return Intent(context, DeliveriesActivity::class.java)
        }
    }
}