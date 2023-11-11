package com.goldden.lucck.volunteerapp.Graphs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.goldden.lucck.volunteerapp.Screens.OrderDetailScreen
import com.goldden.lucck.volunteerapp.Screens.OrderScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = ListOfScreens.Orders.name
    ){
        composable(ListOfScreens.Orders.name){
            OrderScreen(navController = navController)
        }
        composable("${ListOfScreens.DetailScreen.name}/{index}", arguments = listOf(
            navArgument(name = "index"){
                type = NavType.IntType
            }
        )
        ){
            index ->
            index.arguments?.let { OrderDetailScreen(it.getInt("index")) }
        }


    }
}

