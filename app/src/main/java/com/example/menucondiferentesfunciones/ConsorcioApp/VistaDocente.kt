package com.example.menucondiferentesfunciones.ConsorcioApp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.menucondiferentesfunciones.R

class VistaDocente(item:View):RecyclerView.ViewHolder(item) {

    lateinit var imgFoto:ImageView
    lateinit var tvCodigo:TextView
    lateinit var tvNombre:TextView
    lateinit var tvPaterno:TextView
    lateinit var tvMaterno:TextView

    init {
        imgFoto=item.findViewById(R.id.imgFoto)
        tvCodigo=item.findViewById(R.id.tvCodigo)
        tvNombre=item.findViewById(R.id.tvNombre)
        tvPaterno=item.findViewById(R.id.tvPaterno)
        tvMaterno=item.findViewById(R.id.tvMaterno)
    }
}