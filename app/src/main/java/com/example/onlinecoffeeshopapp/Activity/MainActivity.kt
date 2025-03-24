package com.example.onlinecoffeeshopapp.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinecoffeeshopapp.Adapter.CategoryAdapter
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