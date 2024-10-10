package com.example.menucondiferentesfunciones.ListApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.menucondiferentesfunciones.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName:TextView = view.findViewById(R.id.tvCategoryName)
    private val divider:View = view.findViewById(R.id.divider)
    private val viewContainer:CardView = view.findViewById(R.id.viewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){

       val color = if(taskCategory.isSelected){
            R.color.cardSelected
        }else{
            R.color.card
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when(taskCategory){
            TaskCategory.Compras -> {
                tvCategoryName.text = "Compras"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.LCompras))
            }
            TaskCategory.Notas -> {
                tvCategoryName.text = "Notas"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.LNotas))
            }
            TaskCategory.Otros -> {
                tvCategoryName.text = "Otros"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.LOtros))
            }
        }
    }
}