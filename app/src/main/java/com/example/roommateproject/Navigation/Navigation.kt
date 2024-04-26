package com.example.roommateproject.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roommateproject.FrontPage.FrontPage
import com.example.roommateproject.Register.Register
import com.example.roommateproject.Register.RoomLogin

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "FrontPage") {
        composable("Register"){
            Register(navigateRoomLogin = { navController.navigate("RoomLogin") })
        }
        composable("RoomLogin"){
            RoomLogin(navigateFrontPage = { navController.navigate("FrontPage") })
        }
        composable("FrontPage"){
            FrontPage(navigateRegisterPage = { navController.navigate("Register") }) {}
        }
    }
}