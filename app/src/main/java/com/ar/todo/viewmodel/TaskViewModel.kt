package com.ar.todo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ar.todo.model.Task

class TaskViewModel : ViewModel() {

    private var nextId = 1

    var tasks = mutableStateListOf<Task>()
        private set

    fun addTask(title: String) {
        if (title.isBlank()) return

        tasks.add(
            Task(
                id = nextId++,
                title = title
            )
        )
    }

    fun deleteTask(task: Task) {
        tasks.remove(task)
    }

    fun toggleTask(task: Task) {
        val index = tasks.indexOf(task)

        if (index != -1) {
            tasks[index] = task.copy(
                isCompleted = !task.isCompleted
            )
        }
    }
}