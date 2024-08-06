package com.example.klivvrassignment.domain.model


data class CityModel(
    val country : String,
    val city : String,
    val id : Int,
    val location : Location
)
data class Location(
    val lon : Double,
    val lat : Double
)