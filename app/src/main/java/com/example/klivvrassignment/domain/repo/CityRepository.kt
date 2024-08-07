package com.example.klivvrassignment.domain.repo

import com.example.klivvrassignment.domain.model.CityModel

interface CityRepository {
    fun getCities() :List<CityModel>
}