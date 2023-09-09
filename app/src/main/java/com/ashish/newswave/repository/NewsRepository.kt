package com.ashish.newswave.repository

import android.util.Log
import com.ashish.newswave.model.ArticlesItem
import com.ashish.newswave.network.NewsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    private val _newsItems=MutableStateFlow<List<ArticlesItem?>>(emptyList())
    val newsItem:StateFlow<List<ArticlesItem?>>
        get() =_newsItems

    suspend fun getNews(){
        val response = newsApi.getAllNews( "html",
            "FULL",
            "Nepal sourcecountry:NP (sourcelang:eng OR sourcelang:nep)",
            "artlist",
            100,
            "json",
            "hybridrel")
        response.articles?.let { _newsItems.emit(it) }

    }
}
