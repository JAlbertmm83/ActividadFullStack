package com.example.actividadfullstack

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.actividadfullstack.databinding.ItemsmortyBinding
import com.squareup.picasso.Picasso

class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
     private val  binding = ItemsmortyBinding.bind(view)
    fun bind(images:String) {
        Picasso.get().load(images).into(binding.imagen)

    }
}