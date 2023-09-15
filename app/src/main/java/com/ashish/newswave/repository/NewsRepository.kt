package com.ashish.newswave.repository

import com.ashish.newswave.model.NewsItem
import com.ashish.newswave.network.NewsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    private val _newsItems=MutableStateFlow<List<NewsItem?>>(emptyList())
    val newsItem:StateFlow<List<NewsItem?>>
        get() =_newsItems

    suspend fun getNews(){
        val response = newsApi.getAllNews()

        if(response.isSuccessful){
            _newsItems.emit(response.body()!!)
        }

    }
}
