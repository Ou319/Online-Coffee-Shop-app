package com.example.onlinecoffeeshopapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecoffeeshopapp.Model.CatgorieModel
import com.example.onlinecoffeeshopapp.R
import com.example.onlinecoffeeshopapp.databinding.ViewCategorieItemBinding

class CategoryAdapter(
    private val items: MutableList<CatgorieModel>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    inner class CategoryViewHolder(val binding: ViewCategorieItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        context = parent.context
        val binding = ViewCategorieItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CategoryViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val item = items[position]
        holder.binding.titleCategory.text = item.title

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(selectedPosition)
            notifyItemChanged(lastSelectedPosition)
        }

        val backgroundResource = if (selectedPosition == position) {
            R.drawable.selected_category_bg
        } else {
            R.drawable.input_style
        }
        holder.binding.titleCategory.setBackgroundResource(backgroundResource)

    }}