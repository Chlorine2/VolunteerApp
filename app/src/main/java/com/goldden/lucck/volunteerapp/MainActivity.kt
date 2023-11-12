package com.goldden.lucck.volunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.goldden.lucck.volunteerapp.Graphs.HomeNavGraph
import com.goldden.lucck.volunteerapp.Graphs.ListOfScreens
import com.goldden.lucck.volunteerapp.Models.TrackModel
import com.goldden.lucck.volunteerapp.Navigation.BottomNavigation
import com.goldden.lucck.volunteerapp.Screens.CreateOrderScreen
import com.goldden.lucck.volunteerapp.Screens.MainScreen
import com.goldden.lucck.volunteerapp.Screens.MonkeyScreen
import com.goldden.lucck.volunteerapp.Screens.OrderDetailScreen
import com.goldden.lucck.volunteerapp.Screens.OrderScreen
import com.goldden.lucck.volunteerapp.Screens.ProfileScreen
import com.goldden.lucck.volunteerapp.ui.theme.VolunteerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolunteerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background
                ) {
                    HomeNavGraph(navController = rememberNavController())
                    BottomNavigationBar()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VolunteerAppTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar() {
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigation().bottomNavigationItems().forEachIndexed {index,navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = ListOfScreens.Orders.name,
            modifier = Modifier.padding(paddingValues = paddingValues)) {

            composable(ListOfScreens.Orders.name) {
                OrderScreen(navController)
            }
            composable(ListOfScreens.CreateOrder.name){
                MainScreen()
            }

            composable(ListOfScreens.Profile.name) {
                ProfileScreen()
            }
            composable(ListOfScreens.TrackOrder.name) {
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
            composable(ListOfScreens.Monkey.name) {
                MonkeyScreen()
            }

        }
    }
}










