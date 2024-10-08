package com.example.menucondiferentesfunciones.ListApp

sealed class TaskCategory {
    object Compras:TaskCategory()
    object Notas:TaskCategory()
    object Otras:TaskCategory()
}
