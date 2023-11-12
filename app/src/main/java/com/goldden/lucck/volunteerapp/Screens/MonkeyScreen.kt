package com.goldden.lucck.volunteerapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldden.lucck.volunteerapp.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MonkeyScreen(){
    val interactionSource = remember { MutableInteractionSource() }
    val size = remember {
        mutableStateOf(100)
    }
    val capheight = remember {
        mutableStateOf(-25)
    }
    val capwidth = remember {
        mutableStateOf(20)
    }
    val capsize = remember {
        mutableStateOf(60)
    }
    val banana = remember {
        mutableStateOf(50)
    }
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight().paint(
            painterResource(id = R.drawable.jungle),
            contentScale = ContentScale.Crop)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(30.dp)) {
            Image(painter = painterResource(id = R.drawable.banana), contentDescription = "banana",
                modifier = Modifier.size(40.dp))
            Text(text = banana.value.toString(), Modifier.padding(start = 10.dp), fontSize = 20.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 30.dp)) {
            Box{
                Image(
                    painter = painterResource(id = R.drawable.monkey), contentDescription = "monkey",
                    modifier = Modifier
                        .size(size.value.dp)
                        .clickable(interactionSource = interactionSource,
                            indication = null, onClick = {
                                if (banana.value > 3) {
                                    size.value += 8
                                    banana.value -= 3
                                    capheight.value -=3
                                    capsize.value += 6
                                    capwidth.value +=1
                                }
                            }))
                Image(painter = painterResource(id = R.drawable.cap), contentDescription = "hat", modifier = Modifier.size((capsize.value).dp).offset(x = capwidth.value.dp, y = (capheight.value).dp))

            }

        }
    }

}