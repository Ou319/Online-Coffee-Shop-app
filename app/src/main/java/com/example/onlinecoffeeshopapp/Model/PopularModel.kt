package com.example.onlinecoffeeshopapp.Model

data class PopularModel(
    val description:String="",
    val extra:String="",
    val picUrl:String="",
    val price:Double=0.0,
    val rating:Double=0.0,
    val title:String=""
){
    constructor():this("","","",0.0,0.0,"")
}
