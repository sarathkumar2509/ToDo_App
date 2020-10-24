package com.example.todo.ui.ToDo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.R
import com.example.todo.data.db.ToDoDatabase
import com.example.todo.data.db.entity.ToDoItem
import com.example.todo.data.repositories.ToDoRepository
import com.example.todo.others.ToDoItemAdapter
import kotlinx.android.synthetic.main.activity_todo.*

class ToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val database = ToDoDatabase(this)
        val repository = ToDoRepository(database)
        val factory = ToDoViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this,factory).get(ToDoViewModel::class.java)

        val adapter = ToDoItemAdapter(listOf(),viewModel)

        rvToDoitems.layoutManager = LinearLayoutManager(this)
        rvToDoitems.adapter = adapter

        viewModel.getAllToDoItems().observe(this , Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fabAdd.setOnClickListener{
            AddToDoItemBottomDialog(this,
            object : AddBottomDialogListener{
                override fun onAddButtonClicked(item: ToDoItem) {
                    viewModel.insert(item)
                }
            }).show(supportFragmentManager,"BottomSheetDialog")
        }
    }
}