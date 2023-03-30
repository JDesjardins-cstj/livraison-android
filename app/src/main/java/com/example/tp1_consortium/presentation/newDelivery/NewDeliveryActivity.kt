package com.example.tp1_consortium.presentation.newDelivery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tp1_consortium.databinding.ActivityNewDeliveryBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NewDeliveryActivity : AppCompatActivity() {

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
                is NewDeliveryUiState.Error -> it.exception
                is NewDeliveryUiState.Success -> {
                    //les prochaines ligne regarde le nombre d'un élément
                    //SI il est égal a zero il met le slider en gris et on ne peut pas bouger le slider
                    //SINON il change la valeur maximum du slider est égal au montant de l'élément
                    //et

                    if(it.trader.jasmalt == 0.0.toFloat())
                    {
                        binding.sldJasmalt.isEnabled = false
                    }
                    else
                    {
                        binding.sldJasmalt.valueTo = it.trader.jasmalt
                        binding.sldJasmalt.value = binding.sldJasmalt.valueTo
                    }

                    if(it.trader.kreotrium == 0.0.toFloat())
                    {
                        binding.sldKreotrium.isEnabled = false
                    }
                    else
                    {
                        binding.sldKreotrium.valueTo = it.trader.kreotrium
                        binding.sldKreotrium.value = binding.sldKreotrium.valueTo
                    }

                    if(it.trader.xuskian == 0.0.toFloat())
                    {
                        binding.sldXuskian.isEnabled = false
                    }
                    else
                    {
                        binding.sldXuskian.valueTo = it.trader.xuskian
                        binding.sldXuskian.value = binding.sldXuskian.valueTo
                    }

                    if(it.trader.yefrium == 0.0.toFloat())
                    {
                        binding.sldYerium.isEnabled = false
                    }
                    else
                    {
                        binding.sldYerium.valueTo = it.trader.yefrium
                        binding.sldYerium.value = binding.sldYerium.valueTo
                    }

                    if(it.trader.zuscum == 0.0.toFloat())
                    {
                        binding.sldZuscum.isEnabled = false
                    }
                    else
                    {
                        binding.sldZuscum.valueTo = it.trader.zuscum
                        binding.sldZuscum.value = binding.sldZuscum.valueTo

                    }

                    updateSlider()



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
            val amountKreotrium = binding.sldKreotrium.value
            val amountXuskian = binding.sldXuskian.value
            val amountYefrium = binding.sldYerium.value
            val amountZuscum = binding.sldZuscum.value

            //soustraire les montants du convoi
            val amountJasmaltSubstract = binding.sldJasmalt.valueTo - amountJasmalt
            val amountKreotriunSubstract = binding.sldKreotrium.valueTo - amountKreotrium
            val amountXuskianSubstract = binding.sldXuskian.valueTo - amountXuskian
            val amountYefriumSubstract = binding.sldYerium.valueTo - amountYefrium
            val amountZuscumSubstract = binding.sldZuscum.valueTo - amountZuscum

            //
            if(binding.sldJasmalt.value != 0.0.toFloat()
                && binding.sldKreotrium.value != 0.0.toFloat()
                && binding.sldXuskian.value != 0.0.toFloat()
                && binding.sldYerium.value != 0.0.toFloat()
                && binding.sldZuscum.value != 0.0.toFloat())
            {
                viewModel.saveDelivery(amountJasmalt,amountKreotrium,amountXuskian,amountYefrium,amountZuscum)
                viewModel.saveRessources(amountJasmaltSubstract,amountKreotriunSubstract,amountXuskianSubstract,amountYefriumSubstract,amountZuscumSubstract)
                updateSlider()
                finish()
            }
            else
            {
                Toast.makeText(this, "la livraison ne peut etre vide", Toast.LENGTH_LONG).show()
            }







        }

    }

    //cette fonction met les slider est au maximum pour prevenir les problemes
    fun updateSlider(){
        binding.sldKreotrium.value = binding.sldKreotrium.valueTo
        binding.sldJasmalt.value = binding.sldJasmalt.valueTo
        binding.sldXuskian.value = binding.sldXuskian.valueTo
        binding.sldZuscum.value = binding.sldZuscum.valueTo
        binding.sldYerium.value = binding.sldYerium.valueTo
    }



    companion object {
        fun newIntent(context : Context) : Intent {
            return Intent(context, NewDeliveryActivity::class.java)
        }
    }
}