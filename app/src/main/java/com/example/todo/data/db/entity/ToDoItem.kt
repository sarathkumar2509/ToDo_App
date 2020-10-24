package com.example.todo.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class ToDoItem(
    @ColumnInfo(name = "todo_title")
    var title : String,
    @ColumnInfo(name = "todo_description")
    var description : String
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}