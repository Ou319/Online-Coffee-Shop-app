package com.example.onlinecoffeeshopapp.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinecoffeeshopapp.Adapter.CategoryAdapter
import com.example.onlinecoffeeshopapp.Adapter.Popular_Adapter
import com.example.onlinecoffeeshopapp.databinding.ActivityMainBinding
import com.example.onlinecoffeeshopapp.viewmodel.MainviewModel

class MainActivity : FlagActivity() {
    lateinit var binding:ActivityMainBinding
    private val viewModel=MainviewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initCategory()
        initPopular()
    }

    private fun initPopular() {
        binding.circlereload2.visibility=View.VISIBLE

        viewModel.Popular.observe(this, Observer {
            binding.Purpaler.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            binding.Purpaler.adapter=Popular_Adapter(it)
            binding.circlereload2.visibility=View.GONE
        })
        viewModel.loadPopular()
    }

    private fun initCategory() {
        binding.circlereload1.visibility= View.VISIBLE
        viewModel.categories.observe(this, Observer {
            binding.recyclerViewcategorie.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerViewcategorie.adapter=CategoryAdapter(it)
            binding.circlereload1.visibility=View.GONE
        })
        viewModel.loadCategorie()
    }
}