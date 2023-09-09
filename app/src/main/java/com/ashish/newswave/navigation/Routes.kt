package com.ashish.newswave.navigation

sealed class Routes(val route:String){
    object Home: Routes("home")
    object Detail: Routes("detail/{url}")
}
