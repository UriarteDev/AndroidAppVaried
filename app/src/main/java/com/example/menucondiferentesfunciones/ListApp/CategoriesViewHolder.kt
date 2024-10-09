package com.example.menucondiferentesfunciones.ListApp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.menucondiferentesfunciones.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName:TextView = view.findViewById(R.id.tvCategoryName)
    private val divider:View = view.findViewById(R.id.divider)

    fun render(taskCategory: TaskCategory){

        when(taskCategory){
            TaskCategory.Compras -> {
                tvCategoryName.text = "Compras"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.LCompras))
            }
            TaskCategory.Notas -> {
                tvCategoryName.text = "Notas"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.LNotas))
            }
            TaskCategory.Otras -> {
                tvCategoryName.text = "Otras"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.LOtros))
            }
        }
    }
}