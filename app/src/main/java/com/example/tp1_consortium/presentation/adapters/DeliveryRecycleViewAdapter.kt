package com.example.tp1_consortium.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1_consortium.R
import com.example.tp1_consortium.databinding.ItemRessourcesBinding
import com.example.tp1_consortium.domain.models.Delivery

class DeliveryRecycleViewAdapter(var deliveries: List<Delivery> = listOf())
    : RecyclerView.Adapter<DeliveryRecycleViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ressources, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val delivery = deliveries[position]
        holder.bind(delivery)
    }

    override fun getItemCount(): Int = deliveries.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRessourcesBinding.bind(view)

        fun bind(resource: Delivery) {
           with(binding)
           {
               txvK.text=String.format("%.2f",resource.kreotrium)
               txvXu.text=String.format("%.2f",resource.xuskian)
               txvYe.text=String.format("%.2f", resource.yefrium)
               txvZ.text=String.format("%.2f",resource.zuscum)
               txvJ.text=String.format("%.2f",resource.jasmalt)
           }
        }
    }
}