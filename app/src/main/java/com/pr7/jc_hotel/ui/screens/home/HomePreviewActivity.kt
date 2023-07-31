@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class
)

package com.pr7.jc_hotel.ui.screens.home

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jc_hotel.R
import com.pr7.jc_hotel.ui.screens.home.bottomscreens.Hotel
import com.pr7.jc_hotel.ui.screens.home.ui.theme.JC_HotelTheme
import com.pr7.jc_hotel.ui.screens.home.ui.theme.StarColoricon
import com.pr7.jc_hotel.ui.screens.onboarding.onBoardingitem
import com.pr7.jc_hotel.ui.screens.splash.theme.AppColor
import com.pr7.jc_hotel.ui.utilits.statusbarcolorchange
import kotlinx.coroutines.launch

class HomePreviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //statusbarcolorchange
            statusbarcolorchange(window = window, color = Color.Transparent)
            //get Object
            val hotel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("obj", Hotel::class.java)
            } else {
                intent.getParcelableExtra<Hotel>("obj")
            }
            val hoteldata=if (hotel is Hotel) hotel else null
            homeOpenRoomPreview(hotel = hoteldata!!, rememberPagerState{hoteldata.imagesarray.size})
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun homeOpenRoomPreview(hotel: Hotel,pagerState:PagerState) {
    val scope= rememberCoroutineScope()
    Column() {
        HorizontalPager(state = pagerState,contentPadding = PaddingValues(horizontal = 50.dp)) { page: Int ->
            homeopenroomprevitem(array = hotel.imagesarray, pagenumber =page )
        }
        scope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage+1)
        }


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp),
            text =hotel.name,
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.mont_bold))
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "loaction",
                tint = AppColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                modifier = Modifier.wrapContentSize(),
                text =hotel.adress,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.mont_light))
            )

            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(id = R.drawable.round_star_24),
                contentDescription = "star",
                tint = StarColoricon
            )
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text ="4.7",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.mont_light))
            )
        }
        Row() {
            Spacer(modifier = Modifier.width(19.dp))
            Icon(
                painter = painterResource(id = R.drawable.round_airline_seat_individual_suite_24),
                contentDescription = "Bed",
                tint = AppColor,

            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(

                text ="${hotel.beds} beds",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.mont_light))
            )
        }
        Text(

            text ="Hotel da ovqatlar dim yomon, abedda palov kechda oq palov,xullas palov yesang yaltirisan sho`rva ichsang qaltirisan",
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.mont_light)),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.round_fastfood_24),
                    contentDescription = "Bed",
                    tint = AppColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Food",
                    fontFamily = FontFamily(Font(R.font.mont_light)),
                    maxLines = 1
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.round_wifi_24),
                    contentDescription = "Bed",
                    tint = AppColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "WiFi",
                    fontFamily = FontFamily(Font(R.font.mont_light)),
                    maxLines = 1
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_favorite_24),
                    contentDescription = "Liked",
                    tint = AppColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Liked",
                    fontFamily = FontFamily(Font(R.font.mont_light)),
                    maxLines = 1
                )
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = "Location",
                fontFamily = FontFamily(Font(R.font.mont_semibold))
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "View details",
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                color = AppColor
            )
        }


        Image(
            painter = painterResource(id = R.drawable.map),
            contentDescription = "map",
            modifier = Modifier.padding(16.dp).clip(shape = ShapeDefaults.Medium).fillMaxSize(),
            contentScale = ContentScale.Crop,
        )


    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun homeopenroomprevitem(array: Array<Int>,pagenumber:Int) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 5.dp)

    ) {

        Image(
            painter = painterResource(id =array.get(pagenumber)),
            contentDescription = "room open",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.Crop
        )


    }
}