package com.example.actividadfullstack

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val images:List<String>):RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater=LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.itemsmorty, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item :String = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = images.size
}