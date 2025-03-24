package com.example.onlinecoffeeshopapp.Model

data class CatgorieModel(
    val id: Int = 0,
    val title: String = ""
) {
    // No-argument constructor for Firebase
    constructor() : this(0, "")
}