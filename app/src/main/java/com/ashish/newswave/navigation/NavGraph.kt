package com.ashish.newswave.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ashish.newswave.screen.ArticleDetail
import com.ashish.newswave.screen.NewsScreen

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController=navController, startDestination = Routes.Home.route){
        composable(route=Routes.Home.route){
            NewsScreen(navController=navController)
        }

        composable(
            route=Routes.Detail.route,
            arguments= listOf(navArgument("url"){
                type= NavType.StringType
            })
        ){
            val url=it.arguments?.getString("url")!!
            Log.d("URL",url)
            ArticleDetail()
        }
    }
}