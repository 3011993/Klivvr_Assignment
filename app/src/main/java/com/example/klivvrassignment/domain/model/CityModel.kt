package com.example.klivvrassignment.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CityModel(
    val country : String,
    val city : String,
    val id : Int,
    val location : Location
) : Parcelable

@Parcelize
data class Location(
    val lon : Double,
    val lat : Double
) : Parcelable