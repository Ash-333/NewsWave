package com.ashish.newswave.di

import com.ashish.newswave.network.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{

        return Retrofit.Builder()
            .baseUrl("https://api.gdeltproject.org/api/v2/doc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit):NewsApi{
        return retrofit.create(NewsApi::class.java)
    }
}

