package com.example.gestiondetaches.database

import androidx.room.*
import androidx.room.Update
import com.example.gestiondetaches.model.Task

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task)

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<Task>

    @Delete
    suspend fun deleteTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)
    fun insert(task: com.example.gestiondetaches.model.Task)
}
