package com.example.menucondiferentesfunciones.ListApp

sealed class TaskCategory (var isSelected:Boolean = true){
    object Compras:TaskCategory()
    object Notas:TaskCategory()
    object Otros:TaskCategory()
}
