package com.example.register.ui

import android.content.Context
import android.os.UserManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*


@Composable
 fun AppNavigation() {
    val navController = rememberNavController()
    val context= LocalContext.current
    val userPrefs = remember { UserPreferences(context) }
    var startDestination by remember { mutableStateOf("register") }

    LaunchedEffect(Unit) {
        val isRegistered = userPrefs.isUserRegistered()
        startDestination = if(isRegistered)"login" else "register"
    }

    NavHost(navController, startDestination = startDestination) {
        composable("register") { RegisterScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen() }
    }
}
