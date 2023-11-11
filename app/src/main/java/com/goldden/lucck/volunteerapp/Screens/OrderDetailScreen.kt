package com.goldden.lucck.volunteerapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldden.lucck.volunteerapp.R
import com.goldden.lucck.volunteerapp.ViewModel.SharedViewModel

@Composable
fun OrderDetailScreen(index: Int) {
    val switchState = remember {
        mutableStateOf(true)}
    Column {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(60.dp)
                .height(180.dp)
                .fillMaxWidth()
        )

        Text(
            text = "programa",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "description",
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
                    fontSize = 25.sp
        )

        Text(
            text = "Additional Text jSVJJVNj UBbu ug hghhghghghghg aoidgiqggUGUnn   utn gugn" +
                    "GNGUGNgungNGNGN " +
                    "GNNGngianignIGogninignIGN " +
                    "DJJFJNFSONGFINSGDGNG",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )


        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .width(500.dp)
                .size(60.dp)
                .padding(start = 50.dp, end = 50.dp)
                .height(65.dp)
        ) {
            Text(text = "Accept")
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



