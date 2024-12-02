package com.example.gestiondetaches.navigation

import ArticlesPage
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gestiondetaches.AdminPage
import com.example.gestiondetaches.CalendarPage
import com.example.gestiondetaches.ui.pages.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, // تأكد من النوع الصحيح
        startDestination = "login"
    ) {
        composable("login") { LoginPage(navController) }
        composable("articles") { ArticlesPage(navController, mutableMapOf()) }
        composable("calendar") { CalendarPage(navController, mutableMapOf()) }
        composable("admin") { AdminPage(navController) }
    }
}
