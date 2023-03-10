package com.example.tp1_consortium.presentation.Accueil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp1_consortium.presentation.delivery.DeliveriesActivity
import com.example.tp1_consortium.databinding.ActivityAccueilBinding
import com.example.tp1_consortium.presentation.adapters.resourceRecycleViewAdapter

class AccueilActivity : AppCompatActivity() {

    private val viewModel : AccueilViewModel by viewModels()
    private lateinit var binding : ActivityAccueilBinding

    private lateinit var TraderRecyclerViewAdapter: resourceRecycleViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccueilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        TraderRecyclerViewAdapter = resourceRecycleViewAdapter()

        val linearLayoutManager = LinearLayoutManager(this)

        binding.rcvPlanets.layoutManager = linearLayoutManager
        binding.rcvPlanets.adapter = planetRecyclerViewAdapter


        binding.btnOuvrir.setOnClickListener{
            startActivity(DeliveriesActivity.newIntent(this))
        }
    }




}