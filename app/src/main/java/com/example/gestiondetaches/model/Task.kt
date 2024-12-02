package com.example.gestiondetaches.model
import com.example.gestiondetaches.model.Task

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks") // Le nom de la table dans la base de données
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID comme clé primaire avec auto-génération
    val title: String,
    val description: String,
    val date: String
)
