package com.example.tp1_consortium.presentation.delivery

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tp1_consortium.databinding.ActivityDeliveriesBinding
import com.example.tp1_consortium.presentation.newDelivery.newDeliveryActitity
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
                    binding.txvbonRetour.setText(intent.getStringExtra(traderName))
                 }
            }
        }.launchIn(lifecycleScope)


        binding.fabAjout.setOnClickListener {
            startActivity(newDeliveryActitity.newIntent(this))
        }
    }




    companion object {
        var traderName: String = "placeHolder"
        fun newIntent(context : Context,traderNameActivity:String) : Intent {
            val intent = Intent(context, DeliveriesActivity::class.java)
            intent.putExtra(traderName,traderNameActivity)
            return intent
        }
    }
}