package com.example.menucondiferentesfunciones.ListApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menucondiferentesfunciones.R

class TaskAdapter (var task:List<Task>, private val onTaskSelected:(Int) -> Unit):
    RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return task.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(task[position])
        holder.itemView.setOnClickListener { onTaskSelected(position) }

    }
}