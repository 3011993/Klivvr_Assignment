package com.example.klivvrassignment.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
/**
 * Represents a city model with its name, country, unique identifier, and geographical location.
 * @property country The country where the city is located.
 * @property city The name of the city.
 * @property id The unique identifier of the city.
 * @property location The geographical coordinates of the city,represented by a [Location] object.
 */
@Parcelize
data class CityModel(
    val country : String,
    val city : String,
    val id : Int,
    val location : Location
) : Parcelable
/**
 * Represents the geographical coordinates of a location model.
 * @property lon The longitude of the location.
 * @property lat The latitude of the location.
 */
@Parcelize
data class Location(
    val lon : Double,
    val lat : Double
) : Parcelable