package com.example.klivvrassignment.data.repo

import android.content.Context
import com.example.klivvrassignment.data.dto.CityDto
import com.example.klivvrassignment.data.dto.toCityModel
import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.repo.CityRepository
import com.google.gson.Gson

class CityRepositoryImpl : CityRepository {

    override fun getCities(context: Context): List<CityModel> {
        val jsonFileString =
            context.assets.open("cities.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val cityDtoList = gson.fromJson(jsonFileString, Array<CityDto>::class.java).toList()
        return cityDtoList.map { it.toCityModel() }.sortedWith(compareBy({it.city},{it.country}))
    }
}