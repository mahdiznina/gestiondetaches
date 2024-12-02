import com.example.gestiondetaches.model.Task

class GetTasksUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(): List<Task> = repository.getTasks()
}
