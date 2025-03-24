package com.example.onlinecoffeeshopapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinecoffeeshopapp.Model.CatgorieModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import android.util.Log

class MainviewModel : ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _categorie = MutableLiveData<MutableList<CatgorieModel>>()
    val categories: LiveData<MutableList<CatgorieModel>> = _categorie

    fun loadCategorie() {
        val ref = firebaseDatabase.getReference("Category")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val categoryList = mutableListOf<CatgorieModel>()

                for (childSnapshot in snapshot.children) {
                    val category = childSnapshot.getValue(CatgorieModel::class.java)
                    category?.let { categoryList.add(it) }
                }

                _categorie.value = categoryList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MainviewModel", "Failed to load categories", error.toException())
                _categorie.value = mutableListOf() // Provide an empty list on error
            }
        })
    }
}