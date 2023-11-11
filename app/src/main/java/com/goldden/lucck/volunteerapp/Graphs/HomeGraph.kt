package com.goldden.lucck.volunteerapp.Graphs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.goldden.lucck.volunteerapp.Screens.OrderScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = ListOfScreens.Orders.name
    ){
        composable(ListOfScreens.Orders.name){
            OrderScreen()
        }

    }
}

