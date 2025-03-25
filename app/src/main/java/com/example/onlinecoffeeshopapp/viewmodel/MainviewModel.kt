package com.example.onlinecoffeeshopapp.viewmodel

import PopularModel
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


    // for categories
    private val _categorie = MutableLiveData<MutableList<CatgorieModel>>()
    val categories: LiveData<MutableList<CatgorieModel>> = _categorie


    //for Popular
    private val _Popular=MutableLiveData<MutableList<PopularModel>>()
    val Popular:LiveData<MutableList<PopularModel>> = _Popular

    fun loadCategorie() {
        val ref = firebaseDatabase.getReference("Category")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val categoryList = mutableListOf<CatgorieModel>()

                for (childSnapshot in snapshot.children) {
                    val category = childSnapshot.getValue(CatgorieModel::class.java)
                    if(category != null){
                        categoryList.add(category)
                    }
                }

                _categorie.value = categoryList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MainviewModel", "Failed to load categories", error.toException())
                _categorie.value = mutableListOf() // Provide an empty list on error
            }
        })
    }

    fun loadPopular(){
        val ref = firebaseDatabase.getReference("Items")

        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val PopularList= mutableListOf<PopularModel>()

                for (childSnapshot in snapshot.children) {
                    val Popularl = childSnapshot.getValue(PopularModel::class.java)
                    if(Popularl != null){
                        PopularList.add(Popularl)
                    }
                }
                _Popular.value=PopularList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MainviewModel", "Failed to load Popular", error.toException())
                _Popular.value = mutableListOf() // Provide an empty list on error
            }

        })
    }

}