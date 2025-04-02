package com.example.onlinecoffeeshopapp.Adapter

import PopularModel
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinecoffeeshopapp.databinding.ViewholderOffreBinding
import com.example.onlinecoffeeshopapp.databinding.ViewholderPopularBinding

class Offre_Adapter(
    private val items: MutableList<PopularModel>
): RecyclerView.Adapter<Offre_Adapter.OffreViewholder>() {
    class OffreViewholder(val binding: ViewholderOffreBinding):RecyclerView.ViewHolder(binding.root)
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffreViewholder {
        context = parent.context

        val binding = ViewholderOffreBinding.inflate(LayoutInflater.from(context), parent, false)
        return OffreViewholder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OffreViewholder, position: Int) {
        val item = items[position]

        holder.binding.TitleOffre.text=item.title
        holder.binding.priceOffre.text=item.price.toString()

        Glide.with(holder.itemView.context)
            .load(item.picUrl[0])
            .into(holder.binding.imageOffre)
    }
}