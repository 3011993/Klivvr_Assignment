package com.example.klivvrassignment.domain.repo

import com.example.klivvrassignment.common.Resources
import com.example.klivvrassignment.domain.model.CityModel
import kotlinx.coroutines.flow.Flow
/**
 * Repository interface for accessing city data.
 */
interface CityRepository {
    /**
     * Retrieves a flow of city data, wrapped in a [Resources] object to indicate loading, success, or error states.
     *
     * @return A flow of [Resources] objects containing a list of [CityModel] objects.
     */
    suspend fun getCities() : Flow<Resources<List<CityModel>>>
}