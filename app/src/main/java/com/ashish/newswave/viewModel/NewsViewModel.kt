package com.ashish.newswave.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashish.newswave.model.NewsItem
import com.ashish.newswave.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) :ViewModel() {
    val newsItems: StateFlow<List<NewsItem?>>
        get() =newsRepository.newsItem

    init {
        viewModelScope.launch {
            try {
                newsRepository.getNews()
            } catch (e: Exception) {
                // Handle the exception, e.g., show an error message to the user
                e.printStackTrace()
            }
        }
    }
}