package com.ashish.newswave.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ashish.newswave.model.ArticlesItem
import com.ashish.newswave.viewModel.NewsViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun NewsScreen(navController: NavController){
    val newsViewModel:NewsViewModel= hiltViewModel()
    val newsList=newsViewModel.newsItems.collectAsState()

    LazyColumn(
        modifier=Modifier.padding(8.dp)
    ){
        items(newsList.value.sortedByDescending { it?.seendate }){
            NewsItem(newsItem = it!!,navController=navController)
        }
    }


}

@Composable
fun NewsItem(newsItem: ArticlesItem,navController: NavController){
    val date=formatDateTime(newsItem.seendate!!)
    val url=newsItem.url.toString()
    Log.d("URL",url)
    Card(modifier = Modifier.padding(8.dp)

        .clickable {
            navController.navigate("webView")
        },
        shape = RoundedCornerShape(12.dp),
    ){
        Column(
            modifier=Modifier.padding(8.dp)
        ){
            AsyncImage(
                model = newsItem.socialimage ?: "https://shorturl.at/arGVZ",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = newsItem.title!!, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(text="Published at: $date", style = MaterialTheme.typography.bodyLarge)
           Text(text = "Source: ${newsItem.domain!!}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

fun formatDateTime(dateTimeString: String): String {
    val inputFormat = SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d MMM, yyyy h:mm a", Locale.getDefault())
    val date = inputFormat.parse(dateTimeString)
    return outputFormat.format(date!!)
}
//navController.navigate("detail/${newsItem.url}")

