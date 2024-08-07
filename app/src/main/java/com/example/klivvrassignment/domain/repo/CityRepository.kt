package com.example.klivvrassignment.domain.repo

import com.example.klivvrassignment.common.Resources
import com.example.klivvrassignment.domain.model.CityModel
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    suspend fun getCities() : Flow<Resources<List<CityModel>>>
}