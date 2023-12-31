package com.goldden.lucck.volunteerapp.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.goldden.lucck.volunteerapp.Graphs.ListOfScreens

data class BottomNavigation(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {

    //function to get the list of bottomNavigationItems
    fun bottomNavigationItems() : List<BottomNavigation> {
        return listOf(
            BottomNavigation(
                label = "Orders",
                icon = Icons.Filled.List,
                route = ListOfScreens.Orders.name
            ),
            BottomNavigation(
                label = "Create Order",
                icon = Icons.Filled.Create,
                route = ListOfScreens.CreateOrder.name
            ),

            BottomNavigation(
                label = "Profile",
                icon = Icons.Filled.Person,
                route = ListOfScreens.Profile.name
            ),
            BottomNavigation(
                label = "Monkey",
                icon = Icons.Filled.PlayArrow,
                route = ListOfScreens.Monkey.name
            ),
        )
    }
}
