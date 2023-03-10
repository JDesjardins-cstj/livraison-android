package com.example.tp1_consortium.presentation.delivery

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.tp1_consortium.R
import com.example.tp1_consortium.databinding.ActivityDeliveriesBinding

class DeliveriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeliveriesBinding
    private val viewModel : DeliveriesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    companion object {
        fun newIntent(context : Context) : Intent {
            return Intent(context, DeliveriesActivity::class.java)
        }
    }
}