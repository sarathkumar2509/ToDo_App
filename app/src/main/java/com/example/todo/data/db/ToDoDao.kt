package com.example.todo.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todo.data.db.entity.ToDoItem

@Dao
interface ToDoDao {

    @Insert
    suspend fun insert(item: ToDoItem)

    @Delete
    suspend fun delete(item: ToDoItem)

    @Query("SELECT * FROM todo_items" )
    fun getAllToDoItems() : LiveData<List<ToDoItem>>
}