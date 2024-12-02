package com.example.gestiondetaches

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Row to position the image on the left
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start, // Image on the left
            verticalAlignment = Alignment.Top
        ) {
            // Image personnelle
            Image(
                painter = painterResource(id = R.drawable.mahdiznina), // Remplacez par le nom de votre image dans drawable
                contentDescription = "Photo personnelle",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Informations personnelles
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Nom : Mahdi Znina", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Âge : 23 ans", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Université : ISET Kélibia", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Adresse : Kélibia", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Class : terminal DSI31", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Formation : Android Studio avec Kotlin",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Row to position the buttons next to each other
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Add space between the buttons
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Retour button
            Button(onClick = { navController.navigate("articles") }) {
                Text("Retour")
            }

            // Déconnecter button
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier.size(120.dp, 40.dp)
            ) {
                Text(
                    "Déconnecter",
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        }
    }
}
