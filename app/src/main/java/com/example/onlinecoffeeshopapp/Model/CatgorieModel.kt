package com.example.onlinecoffeeshopapp.Model

data class CatgorieModel(
    val id: Int = 0,
    val title: String = ""
) {

    constructor() : this(0, "")
}