package com.example.menucondiferentesfunciones.ConsorcioApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menucondiferentesfunciones.R

class DocenteAdapter(var data:ArrayList<Docente>):RecyclerView.Adapter<VistaDocente>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaDocente {
        var row=LayoutInflater.from(parent.context).inflate(R.layout.item_docente,parent, false)
        return VistaDocente(row)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VistaDocente, position: Int) {
        holder.tvCodigo.setText(data.get(position).codigo.toString())
        holder.tvNombre.setText(data.get(position).nombre)
        holder.tvPaterno.setText(data.get(position).paterno)
        holder.tvMaterno.setText(data.get(position).materno)
    }

}