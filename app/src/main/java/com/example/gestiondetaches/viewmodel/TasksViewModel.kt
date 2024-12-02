import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gestiondetaches.model.Task
import kotlinx.coroutines.launch

class TasksViewModel(
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase
) : ViewModel() {

    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = _tasks

    fun loadTasks() {
        viewModelScope.launch {
            _tasks.value = getTasksUseCase()
        }
    }

    fun addTask(date: String, description: String) {
        val task = Task(
            date = date, description = description,
            id = TODO(),
            title = TODO()
        )
        viewModelScope.launch {
            addTaskUseCase(task)
            loadTasks()  // Recharge les tâches après ajout
        }
    }
}
