package com.example.klivvrassignment.di

import android.content.Context
import com.example.klivvrassignment.data.repo.CityRepositoryImpl
import com.example.klivvrassignment.domain.repo.CityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object KlivverModule {

    @Provides
    fun provideCityRepository(@ApplicationContext context: Context): CityRepository {
        return CityRepositoryImpl(context)
    }

}