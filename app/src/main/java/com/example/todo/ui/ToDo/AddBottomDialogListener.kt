package com.example.todo.ui.ToDo

import com.example.todo.data.db.entity.ToDoItem

interface AddBottomDialogListener {

    fun onAddButtonClicked(item: ToDoItem)
}