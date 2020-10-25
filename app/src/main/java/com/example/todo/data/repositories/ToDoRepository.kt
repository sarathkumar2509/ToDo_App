package com.example.todo.data.repositories

import com.example.todo.data.db.ToDoDatabase
import com.example.todo.data.db.entity.ToDoItem

class ToDoRepository(
    private val db : ToDoDatabase
) {
    suspend fun insert(item : ToDoItem) = db.getToDoDao().insert(item)
    suspend fun delete(item : ToDoItem) = db.getToDoDao().delete(item)

    fun getAllToDoItems() = db.getToDoDao().getAllToDoItems()
}