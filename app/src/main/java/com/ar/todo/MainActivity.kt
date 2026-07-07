package com.ar.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ar.todo.ui.MainScreen
import com.ar.todo.ui.theme.ToDoTheme
import com.ar.todo.viewmodel.TaskViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ToDoTheme {

                val viewModel: TaskViewModel = viewModel()

                MainScreen(viewModel)

            }

        }
    }
}