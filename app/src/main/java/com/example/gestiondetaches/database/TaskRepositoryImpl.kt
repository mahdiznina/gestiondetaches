import com.example.gestiondetaches.database.TaskDao
import com.example.gestiondetaches.model.Task

interface TaskRepository {
    suspend fun getTasks(): List<Task>
    suspend fun addTask(task: Task)
}

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {
    override suspend fun getTasks(): List<Task> {
        return taskDao.getAllTasks()
    }

    override suspend fun addTask(task: Task) {
        taskDao.insert(task)
    }
}
