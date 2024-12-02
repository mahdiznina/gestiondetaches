import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ArticlesPage(navController: NavController, tasks: Map<LocalDate, List<String>>) {
    // Gradient background

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Liste des Articles", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Tâches :", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        // En-tête du tableau
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Tâche", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            Text("Date", modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Affichage des tâches dans un tableau
        LazyColumn {
            tasks.forEach { (date, taskList) ->
                taskList.forEach { task ->
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = task,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Boutons en bas de la page
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier.size(120.dp, 40.dp)
            ) {
                Text(
                    "Déconnecter",
                    style = TextStyle(fontSize = 12.sp)
                )
            }

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.size(120.dp, 40.dp)
            ) {
                Text(
                    "Retour",
                    style = TextStyle(fontSize = 12.sp)
                )
            }

            Button(
                onClick = { navController.navigate("admin") },
                modifier = Modifier.size(120.dp, 40.dp)
            ) {
                Text(
                    "Admin",
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        }
    }
}