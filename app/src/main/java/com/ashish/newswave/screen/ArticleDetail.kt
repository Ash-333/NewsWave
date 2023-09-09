package com.ashish.newswave.screen

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ArticleDetail() {
    val url="https://www.onlinekhabar.com/2023/09/1362648"
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled=true
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, modifier = Modifier.fillMaxSize())
}