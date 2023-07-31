package com.pr7.jc_hotel.ui.screens.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import com.pr7.jc_hotel.ui.utilits.statusbarcolorchange

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            statusbarcolorchange(window = window, Color.Transparent)

        }
    }
}





