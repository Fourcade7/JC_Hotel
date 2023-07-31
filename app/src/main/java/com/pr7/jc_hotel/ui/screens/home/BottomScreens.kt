package com.pr7.jc_hotel.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


sealed class Screens constructor(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : Screens(
        route = "home_screen",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Search : Screens(
        route = "search_screen",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Message : Screens(
        route = "message_screen",
        title = "message",
        icon = Icons.Default.Call
    )
    object Profile : Screens(
        route = "profile_screen",
        title = "Profile",
        icon = Icons.Default.Person
    )
}


@Composable
fun RowScope.addItem(
    screens: Screens,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {

    NavigationBarItem(
        label = {
            Text(text = screens.title)
        },
        icon = {
            Icon(imageVector = screens.icon, contentDescription = "")
        },
        selected = currentDestination?.hierarchy?.any { it.route == screens.route } == true,
        onClick = {
            navHostController.navigate(screens.route)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Black,
            selectedTextColor = Color.Black,
            indicatorColor = Color.White,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray
        ),



        )
}

@Composable
fun BottomBar(navHostController: NavHostController) {

    val screens = listOf(
        Screens.Home,
        Screens.Search,
        Screens.Message,
        Screens.Profile,
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.White
    ) {
        screens.forEach {
            addItem(
                screens = it,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }

}

@Composable
fun bottomNavGraphSetup(
    navHostController: NavHostController
) {


    NavHost(navController = navHostController, startDestination = Screens.Home.route ){
        composable(route = Screens.Home.route){ homeScreen()}
        composable(route = Screens.Search.route){ searchScreen()}
        composable(route = Screens.Message.route){ messageScreen()}
        composable(route = Screens.Profile.route){ profileScreen()}

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainScreen() {


    val navController = rememberNavController()
    Scaffold(
        bottomBar ={ BottomBar(navHostController = navController)}
    ) {
        bottomNavGraphSetup(navHostController = navController)
    }
}