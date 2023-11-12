package com.goldden.lucck.volunteerapp.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldden.lucck.volunteerapp.R
import com.goldden.lucck.volunteerapp.ViewModel.SharedViewModel
import orderList


@Composable
fun ProfileScreen(){
    val switchState = remember {
        mutableStateOf(true)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier

                .padding(30.dp)
                .size(150.dp)
                .width(0.dp)
                .clip(CircleShape)
                .border(
                    BorderStroke(5.dp, Color.Gray),
                    CircleShape
                )
        )


        Text(
            text = "Vlad Baygar",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(100.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = "Is Volunteer", fontSize = 16.sp,
                )

                Switch(
                    checked = switchState.value,
                    onCheckedChange = { switchState.value = it }
                )
            }



        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()  //fill the max height
                .height(1.dp)
        )
        Text(
            text = "My Orders",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        LazyColumn {
            items(orderList) { order ->
                if(order.owned) {
                    SmallOrderCard(order = order) {
                        // Handle click on small order card
                    }
                }
            }
        }
    }

//        Text(
//            text = "Volonters",
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth(),
//            style = MaterialTheme.typography.headlineLarge,
//            color = MaterialTheme.colorScheme.secondary
//        )



    }





