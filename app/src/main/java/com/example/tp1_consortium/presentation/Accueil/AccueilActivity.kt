package com.example.tp1_consortium.presentation.Accueil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tp1_consortium.presentation.delivery.DeliveriesActivity
import com.example.tp1_consortium.databinding.ActivityAccueilBinding
import com.example.tp1_consortium.domain.models.Trader
import com.example.tp1_consortium.domain.repositories.TraderPreferencesRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.random.Random.Default.nextInt

class AccueilActivity : AppCompatActivity() {

    private val viewModel : AccueilViewModel by viewModels()
    private lateinit var binding : ActivityAccueilBinding
    private lateinit var trader: Trader
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccueilBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel.accueilUiState.onEach {
            when (it) {
                AccueilUiState.Empty -> Unit
                is AccueilUiState.Error -> it.exception
                is AccueilUiState.Success -> {
                    binding.edtNom.setText(it.trader.name)
                    binding.incResources.txvK.setText(it.trader.kreotrium.toString())
                    binding.incResources.txvXu.setText(it.trader.xuskian.toString())
                    binding.incResources.txvYe.setText(it.trader.yefrium.toString())
                    binding.incResources.txvZ.setText(it.trader.zuscum.toString())
                    binding.incResources.txvJ.setText(it.trader.jasmalt.toString())
                    trader = it.trader
                }
            }
        }.launchIn(lifecycleScope)




        binding.btnOuvrir.setOnClickListener {
            if (binding.edtNom.text.length == 0) {
                Toast.makeText(this, "Le nom ne peut pas etre vide", Toast.LENGTH_LONG).show()
            } else {
                val nom = binding.edtNom.text.toString()
                val jasmalt = trader.jasmalt
                val kreotrium = trader.kreotrium
                val xuskian = trader.xuskian
                val yefrium = trader.yefrium
                val zuscum = trader.zuscum
                // on sauvegarde le nom dans la bd local
                viewModel.saveName(nom)
                // on sauvegarde les ressources dans la bd local
                viewModel.saveRessources(jasmalt, kreotrium, xuskian, yefrium, zuscum)
                startActivity(DeliveriesActivity.newIntent(this, trader.name))
            }

        }

        binding.btnChargement.setOnClickListener {

            if (binding.edtNom.text.length == 0) {
                Toast.makeText(this, "Le nom ne peut pas etre vide", Toast.LENGTH_LONG).show()
            } else {
                viewModel.recharger(
                    trader.jasmalt,
                    trader.xuskian,
                    trader.kreotrium,
                    trader.yefrium,
                    trader.zuscum
                )
            }
        }
        binding.btnTeleverser.setOnClickListener {
            if (binding.edtNom.text.length == 0) {
                Toast.makeText(this, "Le nom ne peut pas etre vide", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "livraison envoyer", Toast.LENGTH_LONG).show()
                viewModel.deleteAll()
            }
        }

    }



}