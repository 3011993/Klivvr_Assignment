package com.example.klivvrassignment.data.dto

import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.model.Location

data class CityDto(
    val country: String?,
    val name: String?,
    val _id: Int? ,
    val coord: LocationDto?,
)

data class LocationDto(
    val lon: Double?,
    val lat: Double?,
)


fun LocationDto.toLocation(): Location {
    return Location(
        lon = lon ?: 0.0,
        lat = lat ?: 0.0
    )
}

fun CityDto.toCityModel(): CityModel {
    return CityModel(
        country = country ?: "",
        city = name ?: "",
        id = _id ?: 0,
        location = coord?.toLocation() ?: Location(0.0, 0.0)
    )
}
