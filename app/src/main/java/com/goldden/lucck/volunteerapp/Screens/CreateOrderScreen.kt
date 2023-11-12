package com.goldden.lucck.volunteerapp.Screens

import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.goldden.lucck.volunteerapp.MainActivity
import com.goldden.lucck.volunteerapp.Models.OrderCardModel
import com.goldden.lucck.volunteerapp.Models.TaskModel
import com.goldden.lucck.volunteerapp.R

var bitmapList: MutableList<Bitmap> = mutableListOf()

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun CreateOrderScreen(onAddOrder: (OrderCardModel) -> Unit) {

}


@Composable
fun MainScreen() {
    var orders by remember { mutableStateOf(emptyList<OrderCardModel>()) }
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Add TabRow for tasks and orders
        TabRow(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary),
            selectedTabIndex = selectedTabIndex,
            contentColor = MaterialTheme.colorScheme.onPrimary,

        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 },
                text = { Text("Create Task") }
            )
            Tab(
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 },
                text = { Text("Create Order") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display content based on selected tab index
        when (selectedTabIndex) {
            0 -> CreateTask(onAddTask = { /* Handle task addition */ })
            1 -> CreateOrder(onAddOrder = { order ->
                // Update the list of orders
                orders = orders + order
            })
        }

        Spacer(modifier = Modifier.height(16.dp))

        orders.forEach { order ->
            OrderCard(order = order)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun OrderCard(order: OrderCardModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Display order information
            Image(
                painter = painterResource(id = order.photo),
                contentDescription = "Order Photo",
                modifier = Modifier
                    .size(64.dp) // Adjust the size here
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = order.name, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = order.description)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = order.city)
            }
        }
    }
}


@Composable
fun PhotoPicker(){
    var uri by remember{
        mutableStateOf<Uri?>(null)
    }

    val PhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            uri = it
        })



    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedButtonExample(
            { PhotoPicker.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }
        )
    }

    AsyncImage(
        model = uri,
        contentDescription = null,
        modifier = Modifier.size(0.dp),
        contentScale = ContentScale.Crop

    )



}

@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth() // Adjust the width as needed
            .height(56.dp), // Adjust the height as needed
    shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            "Add Photo",
            fontSize = 18.sp, // Adjust the text size as needed
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateOrder(onAddOrder: (OrderCardModel) -> Unit){
    var name by remember { mutableStateOf("") }
    var photo by remember { mutableStateOf(0) }
    var description by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_6),
                    contentDescription = "Name",
                    modifier = Modifier.size(24.dp) // Adjust the size here
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )


        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_4),
                    contentDescription = "Description",
                    modifier = Modifier.size(24.dp) // Adjust the size here
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Sender city") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = "City",
                    modifier = Modifier.size(24.dp) // Adjust the size here
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Recipient City") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = "City",
                    modifier = Modifier.size(24.dp) // Adjust the size here
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Column(        Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween) {
            PhotoPicker()
            Button(
                onClick = {

                },
                modifier = Modifier

                    .fillMaxWidth()
                    .height(56.dp)
                    .weight(1f, false)
                ,
                shape = RoundedCornerShape(10.dp)

            ) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "Add Order")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Add Order")
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTask(onAddTask: (TaskModel) -> Unit){
    var name by remember { mutableStateOf("") }
    var photo by remember { mutableStateOf(0) }
    var description by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_6),
                    contentDescription = "Name",
                    modifier = Modifier.size(24.dp) // Adjust the size here
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )


        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_4),
                    contentDescription = "Description",
                    modifier = Modifier.size(24.dp) // Adjust the size here
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("City") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = "City",
                    modifier = Modifier.size(24.dp) // Adjust the size here
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Price") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = "Price",
                    modifier = Modifier.size(24.dp) // Adjust the size here
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Column(        Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween) {
            PhotoPicker()
            Button(
                onClick = {

                },
                modifier = Modifier

                    .fillMaxWidth()
                    .height(56.dp)
                    .weight(1f, false)
                ,
                shape = RoundedCornerShape(10.dp)

            ) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "Add Order")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Add Order")
            }
        }

    }
}
