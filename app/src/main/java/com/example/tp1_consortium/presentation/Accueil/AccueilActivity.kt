package com.example.tp1_consortium.presentation.Accueil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp1_consortium.presentation.delivery.DeliveriesActivity
import com.example.tp1_consortium.databinding.ActivityAccueilBinding
import com.example.tp1_consortium.domain.models.models.Trader
import com.example.tp1_consortium.presentation.adapters.resourceRecycleViewAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AccueilActivity : AppCompatActivity() {

    private val viewModel : AccueilViewModel by viewModels()
    private lateinit var binding : ActivityAccueilBinding
    private var trader = listOf<Trader>()

    private lateinit var TraderRecyclerViewAdapter: resourceRecycleViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccueilBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val linearLayoutManager = LinearLayoutManager(this)


        viewModel.accueilUiState.onEach {
            when(it){
                AccueilUiState.Empty -> Unit
                is AccueilUiState.Error -> TODO()
                is AccueilUiState.Success -> {
                    if(binding.edtNom.text.length == 0)
                    {

                    }
                }
            }
        }.launchIn(lifecycleScope)

       /* with(binding)
        {
            incResources.txvJ.text = trader[0].jasmalt.toString()
            incResources.txvZ.text = trader[0].zuscum.toString()
            incResources.txvYe.text = trader[0].yefrium.toString()
            incResources.txvK.text = trader[0].kreotrium.toString()
            incResources.txvXu.text=trader[0].xuskian.toString()
        }*/


        binding.btnOuvrir.setOnClickListener{
            startActivity(DeliveriesActivity.newIntent(this))
        }
    }




}