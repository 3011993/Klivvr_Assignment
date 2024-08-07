package com.example.klivvrassignment.di

import android.content.Context
import com.example.klivvrassignment.data.repo.CityRepositoryImpl
import com.example.klivvrassignment.domain.repo.CityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
/**
 * Hilt module that provides dependencies for the Klivver application.
 */
@Module
@InstallIn(SingletonComponent::class)
object KlivverModule {
    /**
    * Provides an instance of [CityRepository].
    *
    * @param context The application context.
    * @return An instance of [CityRepositoryImpl].
    */
    @Provides
    fun provideCityRepository(@ApplicationContext context: Context): CityRepository {
        return CityRepositoryImpl(context)
    }

}