package com.example.todo.ui.ToDo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.todo.R
import com.example.todo.data.db.ToDoDatabase
import com.example.todo.data.repositories.ToDoRepository

class ToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val database = ToDoDatabase(this)
        val repository = ToDoRepository(database)
        val factory = ToDoViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this,factory).get(ToDoViewModel::class.java)
    }
}