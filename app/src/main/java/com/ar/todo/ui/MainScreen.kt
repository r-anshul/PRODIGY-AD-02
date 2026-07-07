package com.ar.todo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ar.todo.model.Task
import com.ar.todo.viewmodel.TaskViewModel
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: TaskViewModel) {

    var taskText by remember { mutableStateOf("") }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text("AR To-Do List")
                }

            )

        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    value = taskText,
                    onValueChange = { taskText = it },
                    modifier = Modifier.weight(1f),
                    label = {
                        Text("Enter Task")
                    }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        viewModel.addTask(taskText)
                        taskText = ""
                    }
                ) {
                    Text("Add")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            StatsCard(
                total = viewModel.tasks.size,
                completed = viewModel.tasks.count { it.isCompleted },
                pending = viewModel.tasks.count { !it.isCompleted }
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (viewModel.tasks.isEmpty()) {

                Text("No tasks yet")

            } else {

                LazyColumn {

                    items(viewModel.tasks) { task ->

                        TaskItem(
                            task = task,
                            onCheckedChange = {
                                viewModel.toggleTask(task)
                            },
                            onDelete = {
                                viewModel.deleteTask(task)
                            }
                        )

                    }

                }

            }

        }
    }

}