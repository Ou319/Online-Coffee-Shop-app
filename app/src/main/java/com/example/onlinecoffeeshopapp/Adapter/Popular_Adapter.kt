package com.example.onlinecoffeeshopapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecoffeeshopapp.Model.CatgorieModel
import com.example.onlinecoffeeshopapp.Model.PopularModel
import com.example.onlinecoffeeshopapp.databinding.ViewCategorieItemBinding
import com.example.onlinecoffeeshopapp.databinding.ViewholderPopularBinding

class Popular_Adapter(
    private val items: MutableList<PopularModel>
):RecyclerView.Adapter<Popular_Adapter.PopularViewHolder>() {

    private lateinit var context: Context
    inner class PopularViewHolder(val binding: ViewholderPopularBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        holder.binding.titlePopular.text=item.title
        holder.binding.pricePopular.text=item.price.toString()
        holder.binding.extratext.text=item.extra
        holder.binding.ratingBar.numStars=item.rating.toInt()
    }

    override fun getItemCount(): Int {
        return items.size
    }




}