package com.example.loginjetpackcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavitingPanel(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "registerDestination",

    ) {
        composable("registerDestination") {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                RegisterScreen(navController,modifier = Modifier.padding(innerPadding))
            }

        }
        composable("loginDestination") {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                LoginScreen(navController,modifier = Modifier.padding(innerPadding))
            }
        }

    }
}
