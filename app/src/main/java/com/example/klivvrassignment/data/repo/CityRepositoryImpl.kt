package com.example.klivvrassignment.data.repo

import android.content.Context
import com.example.klivvrassignment.common.Resources
import com.example.klivvrassignment.data.dto.CityDto
import com.example.klivvrassignment.data.dto.toCityModel
import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.repo.CityRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(private val context: Context) : CityRepository {
    override suspend fun getCities(): Flow<Resources<List<CityModel>>> {
        return flow {
            emit(Resources.Loading())
            val jsonFileString =
                context.assets.open("cities.json").bufferedReader().use { it.readText() }
            val gson = Gson()
            val cityDtoList = gson.fromJson(jsonFileString, Array<CityDto>::class.java).toList()
            val cityModelList = cityDtoList.map { it.toCityModel() }
                .sortedWith(compareBy({ it.city }, { it.country }))
            emit(Resources.Success(cityModelList))
        }.catch { e ->
            emit(Resources.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}

