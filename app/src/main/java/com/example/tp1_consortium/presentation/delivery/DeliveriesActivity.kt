package com.example.tp1_consortium.presentation.delivery

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tp1_consortium.R
import com.example.tp1_consortium.databinding.ActivityDeliveriesBinding
import com.example.tp1_consortium.presentation.adapters.DeliveryRecycleViewAdapter
import com.example.tp1_consortium.presentation.newDelivery.NewDeliveryActivity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DeliveriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeliveriesBinding
    private val viewModel : DeliveriesViewModel by viewModels()

    private val deliveryRecyclerViewAdapter = DeliveryRecycleViewAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveriesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // affiche les données sur l'écran
        binding.rcvDeliveries.layoutManager = GridLayoutManager(this, 1)
        binding.rcvDeliveries.adapter = deliveryRecyclerViewAdapter

        viewModel.deliveriesUiState.onEach {
            when(it){
                DeliveriesUiState.Empty -> Unit
                is DeliveriesUiState.Error -> it.exception
                is DeliveriesUiState.Success -> {
                    binding.txvbonRetour.setText(getString(R.string.bonRetour, it.trader.name ))
                    deliveryRecyclerViewAdapter.deliveries = it.delivery
                    deliveryRecyclerViewAdapter.notifyDataSetChanged()
                 }
            }
        }.launchIn(lifecycleScope)


        binding.fabAjout.setOnClickListener {
            startActivity(NewDeliveryActivity.newIntent(this))
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