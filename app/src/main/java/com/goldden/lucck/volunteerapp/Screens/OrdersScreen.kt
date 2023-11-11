package com.goldden.lucck.volunteerapp.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.goldden.lucck.volunteerapp.Graphs.ListOfScreens
import com.goldden.lucck.volunteerapp.Models.OrderCardModel
import com.goldden.lucck.volunteerapp.R
import orderList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(navController: NavController) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Orders")
                },
                actions = {
                    IconButton(
                        onClick = { /* Handle search click */ }
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(
                        onClick = {
                            navController.navigate(ListOfScreens.TrackOrder.name)
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.img_2),
                            contentDescription = "Track"
                        )

                    }
                }
            )
        },
        content = {
                padding ->
            Box(modifier = Modifier.padding(padding)) {
                OrderList(orders = orderList, navController)
            }
        }
    )

}

@Composable
fun OrderList(orders: List<OrderCardModel>, navController: NavController) {
    LazyColumn {
        items(orders) { order ->
            OrderCard(order = order) { navController.navigate(route = "DetailScreen/${order.id}") }
            Spacer(modifier = Modifier.height(8.dp)) // Add some spacing between cards
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderCard(order: OrderCardModel,  onClickDetail : () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = onClickDetail
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colorScheme.secondary
                ) {
                    Text(
                        text = "New release",
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = order.name, // Use data from OrderCardModel
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))


                Spacer(modifier = Modifier.height(2.dp))



                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = order.city, // Use data from OrderCardModel
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),

                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Read More",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(140.dp)
            ) {
                Image(
                    painter = painterResource(id = order.photo), // Use data from OrderCardModel
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }
    }
}










