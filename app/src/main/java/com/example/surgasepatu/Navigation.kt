package com.example.surgasepatu

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.surgasepatu.model.ScreenNavigation
import com.example.surgasepatu.view.component.BottomNavBar
import com.example.surgasepatu.view.screens.CartScreen
import com.example.surgasepatu.view.screens.HistoryScreen
import com.example.surgasepatu.view.screens.HomeScreen
import com.example.surgasepatu.view.screens.LoginScreen
import com.example.surgasepatu.view.screens.ProfileScreen
import com.example.surgasepatu.view.screens.RegisterScreen
import com.example.surgasepatu.view.screens.ResetPasswordScreen
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun Navigation() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route
    var backPressed by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var resetBackPressed by remember { mutableStateOf<Job?>(null) }

    BackHandler(enabled = currentRoute == ScreenNavigation.Home.route) {
        if (backPressed) {
            resetBackPressed?.cancel()
            (context as Activity). finish()
        } else {
            backPressed = true
            Toast.makeText(
                context,
                "Tekan sekali lagi untuk keluar",
                Toast.LENGTH_SHORT
            ).show()

            resetBackPressed = coroutineScope.launch {
                kotlinx.coroutines.delay(3000)
                backPressed = false
            }
        }
    }

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf(
                    ScreenNavigation.Home.route,
                    ScreenNavigation.Cart.route,
                    ScreenNavigation.History.route,
                    ScreenNavigation.Profile.route
                )
            )
                BottomNavBar(navController)
        }
    ) { innerPadding->

        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") {
                LoginScreen(
                    navController = navController,
                    context = context
                )
            }

            composable("register") {
                RegisterScreen(
                    navController = navController,
                    context = context
                )
            }

            composable("reset password") {
                ResetPasswordScreen(
                    navController = navController,
                    context = context
                )
            }

            composable("home") {
                HomeScreen()
            }

            composable("cart") {
                CartScreen()
            }

            composable("history") {
                HistoryScreen()
            }

            composable("profile") {
                ProfileScreen()
            }
        }
    }
}