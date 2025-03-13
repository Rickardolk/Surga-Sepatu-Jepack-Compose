package com.example.surgasepatu.model

import androidx.activity.compose.ReportDrawn
import com.example.surgasepatu.R

sealed class ScreenNavigation (
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Home: ScreenNavigation("home", "Home", R.drawable.ic_home)
    data object Cart: ScreenNavigation("cart", "Cart", R.drawable.ic_cart)
    data object History: ScreenNavigation("history", "History", R.drawable.ic_history)
    data object Profile: ScreenNavigation("profile", "Profile", R.drawable.ic_profile)
}