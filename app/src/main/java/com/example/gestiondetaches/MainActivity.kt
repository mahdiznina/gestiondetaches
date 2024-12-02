package com.example.gestiondetaches

import ArticlesPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestiondetaches.ui.pages.LoginPage
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface {
            content()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // State for tasks data, mutable and persistent across recompositions
    var tasks by remember { mutableStateOf(mutableMapOf<LocalDate, MutableList<String>>()) }

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController) }
        composable("articles") { ArticlesPage(navController, tasks) } // صفحة المقالات
        composable("admin") { AdminPage(navController) }
        composable("calendar") {
            CalendarPage(navController = navController, tasks = tasks) // صفحة التقويم
        }
    }
}