package com.example.surgasepatu.view.component

import android.content.Context
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionErrors
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.surgasepatu.R
import com.example.surgasepatu.model.ScreenNavigation

@Composable
fun BottomNavBar(
    navController: NavController
) {
    val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route

    NavigationBar(
        containerColor = Color.Transparent
    ) {
        listOf(
            ScreenNavigation.Home,
            ScreenNavigation.Cart,
            ScreenNavigation.History,
            ScreenNavigation.Profile
        ).forEach { screen->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {saveState = true}
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title
                    )
                },
                label = { Text(text = screen.title)},
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.ocean_boat_blue),
                    selectedTextColor = colorResource(id = R.color.ocean_boat_blue),
                    unselectedIconColor = colorResource(id = R.color.onyx_black),
                    unselectedTextColor = colorResource(id = R.color.onyx_black),
                    indicatorColor = Color.Transparent
                )
            )
        }
    }


}