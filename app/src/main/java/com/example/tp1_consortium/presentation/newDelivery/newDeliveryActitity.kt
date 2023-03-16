package com.example.tp1_consortium.presentation.newDelivery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tp1_consortium.databinding.ActivityNewDeliveryBinding

class newDeliveryActitity : AppCompatActivity() {

    private lateinit var binding: ActivityNewDeliveryBinding
    private val viewModel : newDeliveryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    companion object {
        fun newIntent(context : Context) : Intent {
            return Intent(context, newDeliveryActitity::class.java)
        }
    }
}