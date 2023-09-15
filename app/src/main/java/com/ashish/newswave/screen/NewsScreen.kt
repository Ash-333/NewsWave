package com.ashish.newswave.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ashish.newswave.model.NewsItem

@Composable
fun NewsItem(newsItem: NewsItem,onClick: (url: String) -> Unit){

    val url=""+newsItem.link
    Card(modifier = Modifier.padding(8.dp)
        .fillMaxHeight(0.7f)
        .clickable {
           onClick(url)
        },
        shape = RoundedCornerShape(12.dp),
    ){
        Column(
            modifier=Modifier.padding(12.dp)
        ){
            AsyncImage(
                model = newsItem.imgUrl ?: "https://shorturl.at/arGVZ",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = newsItem.title!!, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = newsItem.description!!, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold, maxLines = 7)
        }
    }
}

