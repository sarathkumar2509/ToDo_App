package com.example.todo.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.data.db.entity.ToDoItem
import com.example.todo.ui.ToDo.ToDoViewModel
import kotlinx.android.synthetic.main.todo_item.view.*

class ToDoItemAdapter : RecyclerView.Adapter<ToDoItemAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)


    private val differCallback = object : DiffUtil.ItemCallback<ToDoItem>(){
        override fun areItemsTheSame(oldItem: ToDoItem, newItem: ToDoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToDoItem, newItem: ToDoItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {

        val currentToDoItem = differ.currentList[position]

        holder.itemView.tvTitle.text = currentToDoItem.title
        holder.itemView.tvDescription.text = currentToDoItem.description

        //code for imageview to add favorites

    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }
}