package com.ashish.newswave.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashish.newswave.viewModel.NewsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun News(onClick:(url:String)->Unit) {
    val newsViewModel: NewsViewModel = hiltViewModel()
    val newsList=newsViewModel.newsItems.collectAsState().value
    Box (modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)){
        VerticalPager(pageCount = newsList.size, modifier = Modifier.align(Alignment.Center)) {
            NewsItem(newsItem = newsList[it]!!,onClick)
        }
    }
}