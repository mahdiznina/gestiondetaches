import com.example.gestiondetaches.model.Task

class AddTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) = repository.addTask(task)
}
