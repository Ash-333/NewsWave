package com.ashish.newswave

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ashish.newswave.screen.ArticleDetail
import com.ashish.newswave.screen.NewsScreen
import com.ashish.newswave.ui.theme.NewsWaveTheme
import com.ashish.newswave.viewModel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val newsViewModel:NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsWaveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()


                }
            }
        }
        lifecycleScope.launch {
            newsViewModel.newsItems.collect { newsItems ->
                // Log the newsItems here
                Log.d("RESPONSE", newsItems.toString())
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "newsList"
    ) {
        composable("newsList") {
            NewsScreen(navController = navController)
        }
        composable(
            "webView"
//            route = "webView/{url}",
//            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) {
//            val url = backStackEntry.arguments?.getString("url") ?: ""
            ArticleDetail()
        }
    }
}


