package com.ashish.newswave.network

import com.ashish.newswave.model.Article
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("doc")
    suspend fun getAllNews(
        @Query("format") format: String,
        @Query("timespan") timespan: String,
        @Query("query") query: String,
        @Query("mode") mode: String,
        @Query("maxrecords") maxRecords: Int,
        @Query("format") responseFormat: String,
        @Query("sort") sort: String):Article
}