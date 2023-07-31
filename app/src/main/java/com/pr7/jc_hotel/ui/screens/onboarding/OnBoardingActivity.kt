@file:OptIn(ExperimentalFoundationApi::class)

package com.pr7.jc_hotel.ui.screens.onboarding

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jc_hotel.R
import com.pr7.jc_hotel.ui.screens.splash.theme.Buttonbackground
import com.pr7.jc_hotel.ui.utilits.statusbarcolorchange
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            statusbarcolorchange(window = window)
            mainScreen()
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun mainScreen() {
    val pagerState = rememberPagerState { 3 }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Column() {
        Column(modifier = Modifier.weight(3f)) {
            onBoardingScreen(pagerState = pagerState)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            when (pagerState.currentPage) {
                        0 -> {
                            dot1()
                        }

                        1 -> {
                            dot2()
                        }

                        2 -> {
                            dot3()
                        }

                        else -> {
                            dot1()
                        }
                    }

        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(64.dp)
                .clickable {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                    if (pagerState.currentPage == 2) {
                        Log.d("PR77777", "onBoardMain: GG")
                        //context.startActivity(Intent(context, ChangeActivity::class.java))


                    }

                },
            shape = RoundedCornerShape(35.dp),
            color = Buttonbackground
        ) {
            Column(verticalArrangement = Arrangement.Center) {

                Text(
                    text = if (pagerState.currentPage == 2) "Get Started" else "Next",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.mont_semibold)),
                    fontSize = 17.sp,
                    color = Color.White
                )
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
    }


}


@Preview
@Composable
fun dot1() {
    Row() {

        Image(
            painter = painterResource(id = R.drawable.baseline_lens_sky_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_lens_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_lens_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
    }
}

@Preview
@Composable
fun dot2() {
    Row() {

        Image(
            painter = painterResource(id = R.drawable.baseline_lens_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_lens_sky_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_lens_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
    }
}

@Preview
@Composable
fun dot3() {
    Row() {

        Image(
            painter = painterResource(id = R.drawable.baseline_lens_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_lens_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_lens_sky_24),
            contentDescription = "lens",
            modifier = Modifier.size(18.dp)
        )
    }
}


