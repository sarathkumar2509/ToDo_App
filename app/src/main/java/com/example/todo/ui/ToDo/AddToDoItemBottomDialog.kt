package com.example.todo.ui.ToDo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.todo.R
import com.example.todo.data.db.entity.ToDoItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_dialog_todo_item.*

class AddToDoItemBottomDialog(context: Context , var addBottomDialogListener: AddBottomDialogListener) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_dialog_todo_item,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvAdd.setOnClickListener {
            val title = etTaskTitle.text.toString()
            val description = etTaskDescription.text.toString()

            if (title.isEmpty() || description.isEmpty()){
                Toast.makeText(context,"Please fill all Details",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ToDoItem(title,description)
            addBottomDialogListener.onAddButtonClicked(item)
            dismiss()
        }


    }
}