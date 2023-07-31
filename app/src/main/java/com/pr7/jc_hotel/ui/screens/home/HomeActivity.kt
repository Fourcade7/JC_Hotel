package com.pr7.jc_hotel.ui.screens.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jc_hotel.ui.screens.home.bottomscreens.bottombarScreen
import com.pr7.jc_hotel.ui.screens.splash.theme.AppColor
import com.pr7.jc_hotel.ui.utilits.statusbarcolorchange

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            statusbarcolorchange(window = window, color = AppColor)
            homescrrenmain()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun homescrrenmain() {
    Column(modifier = Modifier.fillMaxSize()) {

        Card(elevation = CardDefaults.cardElevation(2.dp)) {
            bottombarScreen()
        }



    }
}