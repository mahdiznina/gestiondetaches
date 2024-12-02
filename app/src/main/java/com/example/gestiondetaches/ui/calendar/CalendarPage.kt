package com.example.gestiondetaches

import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarPage(navController: NavController, tasks: MutableMap<LocalDate, MutableList<String>>) {
    var selectedDate by rememberSaveable { mutableStateOf(LocalDate.now()) }
    var taskText by rememberSaveable { mutableStateOf("") }

    val dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
    // Gradient background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4CAF50), // Green
                        Color(0xFF2196F3)  // Blue
                    )
                )
            )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Calendrier", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // التقويم لاختيار التاريخ
        AndroidView(
            factory = { context ->
                CalendarView(context).apply {
                    setOnDateChangeListener { _, year, month, dayOfMonth ->
                        // تحديث التاريخ عند تغييره من التقويم
                        selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // عرض التاريخ المحدد
        Text(
            "Date sélectionnée : ${selectedDate.format(dateFormatter)}",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // إدخال المهمة
        TextField(
            value = taskText,
            onValueChange = { taskText = it },
            label = { Text("Nouvelle tâche") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // زر إضافة المهمة
        Button(
            onClick = {
                if (taskText.isNotEmpty()) {
                    tasks.getOrPut(selectedDate) { mutableListOf() }.add(taskText)
                    taskText = "" // إعادة تعيين الحقل
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            border = ButtonDefaults.outlinedButtonBorder
        ) {
            Text("Ajouter tâche")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // عرض المهام للتاريخ المحدد
        val tasksForSelectedDate = tasks[selectedDate] ?: emptyList()
        if (tasksForSelectedDate.isNotEmpty()) {
            Text(
                "Tâches pour ${selectedDate.format(dateFormatter)} :",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            // قائمة المهام
            tasksForSelectedDate.forEachIndexed { index, task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("- $task", Modifier.weight(1f))
                    Button(
                        onClick = {
                            tasks[selectedDate]?.let {
                                it.removeAt(index)
                                if (it.isEmpty()) {
                                    tasks.remove(selectedDate)
                                }
                            }
                        },
                        modifier = Modifier.padding(start = 8.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                        ),
                        border = ButtonDefaults.outlinedButtonBorder
                    ) {
                        Text("Supprimer")
                    }
                }
            }
        } else {
            Text("Aucune tâche pour cette date.")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // زر العودة
        Button(
            onClick = { navController.navigate("articles") },
            modifier = Modifier.padding(start = 16.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            border = ButtonDefaults.outlinedButtonBorder
        ) {
            Text("La liste des articles")
        }
    }
}
