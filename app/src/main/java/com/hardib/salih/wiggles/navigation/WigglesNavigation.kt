package com.hardib.salih.wiggles.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hardib.salih.wiggles.models.FakeDogDatabase
import com.hardib.salih.wiggles.screen.Details
import com.hardib.salih.wiggles.screen.Home
import com.hardib.salih.wiggles.services.SharedViewModel

@Composable
fun WigglesNavigation (toggleTheme: () -> Unit) {
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(navController = navController,
        startDestination = WigglesScreen.HomeScreen.name
    ){
        composable(WigglesScreen.HomeScreen.name) {
            //Path HomeScreen
            Home(navHostController = navController,
                sharedViewModel =sharedViewModel,
                dogList = FakeDogDatabase.dogList,
                toggleTheme = {toggleTheme()})
        }

        composable(WigglesScreen.DetailScreen.name){
            Details(navController = navController,
                sharedViewModel = sharedViewModel)
        }

    }
}