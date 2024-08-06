package com.example.klivvrassignment.domain.repo

import android.content.Context
import com.example.klivvrassignment.domain.model.CityModel

interface CityRepository {
    fun getCities(context : Context) : List<CityModel>
}