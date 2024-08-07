package com.example.klivvrassignment.data.dto

import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.model.Location
/**
 * Data Transfer Object (DTO) representing a city as received from a Json File
 * @property country The country where the city is located (nullable).
 * @property name The name of the city (nullable).
 * @property _id The unique identifier of the city (nullable).
 * @property coord The geographical coordinates of the city, representedby a [LocationDto] object (nullable).
 */
data class CityDto(
    val country: String?,
    val name: String?,
    val _id: Int? ,
    val coord: LocationDto?,
)
/**
 * Data Transfer Object (DTO) representing geographical coordinates.
 *
 * @property lon The longitude of the location (nullable).
 * @property lat The latitude of the location (nullable).
 */
data class LocationDto(
    val lon: Double?,
    val lat: Double?,
)

/**
 * Converts a [LocationDto] object toa [Location] object, handling null values.
 *
 * @return A [Location] object with longitude and latitude values, defaulting to 0.0 if null.
 */
fun LocationDto.toLocation(): Location {
    return Location(
        lon = lon ?: 0.0,
        lat = lat ?: 0.0
    )
}
/**
 * Converts a [CityDto] object to a [CityModel] object, handling null values.
 *
 * @return A [CityModel] object with country, city, id, and location values, using default values if null.
 */

fun CityDto.toCityModel(): CityModel {
    return CityModel(
        country = country ?: "",
        city = name ?: "",
        id = _id ?: 0,
        location = coord?.toLocation() ?: Location(0.0, 0.0)
    )
}
