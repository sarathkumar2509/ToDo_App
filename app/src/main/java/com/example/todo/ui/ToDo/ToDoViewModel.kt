package com.example.todo.ui.ToDo

import androidx.lifecycle.ViewModel
import com.example.todo.data.db.entity.ToDoItem
import com.example.todo.data.repositories.ToDoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(
    private val repository: ToDoRepository
) : ViewModel(){

    fun insert(item: ToDoItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ToDoItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllToDoItems()
}