package com.ashish.newswave.network

import com.ashish.newswave.model.NewsItem
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    @GET("items")
    suspend fun getAllNews(): Response<List<NewsItem>>
}