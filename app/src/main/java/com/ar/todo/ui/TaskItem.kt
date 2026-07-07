package com.ar.todo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.ar.todo.model.Task
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun TaskItem(
    task: Task,
    onCheckedChange: () -> Unit,
    onDelete: () -> Unit
) {Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp),
    shape = RoundedCornerShape(12.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = {
                onCheckedChange()
            }
        )

        Text(
            text = task.title,
            modifier = Modifier.weight(1f),
            textDecoration =
                if (task.isCompleted)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None
        )

        IconButton(
            onClick = onDelete
        ) {

            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Task"
            )

        }

    }

}
}