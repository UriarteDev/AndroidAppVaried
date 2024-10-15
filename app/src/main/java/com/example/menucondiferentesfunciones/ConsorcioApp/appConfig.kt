package com.example.menucondiferentesfunciones.ConsorcioApp

import android.app.Application
import android.content.Context

class appConfig:Application() {

    companion object{
        lateinit var CONTEXTO:Context
    }

    override fun onCreate() {
        CONTEXTO.applicationContext
        super.onCreate()
    }
}