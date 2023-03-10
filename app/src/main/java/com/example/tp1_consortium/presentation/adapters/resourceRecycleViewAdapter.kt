package com.example.tp1_consortium.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tp1_consortium.R
import com.example.tp1_consortium.databinding.ItemRessourcesBinding
import com.example.tp1_consortium.domain.models.Trader

class resourceRecycleViewAdapter(var resources: List<Trader> = listOf())
    : RecyclerView.Adapter<resourceRecycleViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ressources, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resource = resources[position]
        holder.bind(resource)
    }

    override fun getItemCount(): Int = resources.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRessourcesBinding.bind(view)

        fun bind(resource: Trader) {
           with(binding)
           {
               txvK.text = resource.kreotrium.toString()
               txvXu.text = resource.xuskian.toString()
               txvYe.text = resource.yefrium.toString()
               txvZ.text = resource.zuscum.toString()
               txvJ.text = resource.jasmalt.toString()
           }
        }
    }
}