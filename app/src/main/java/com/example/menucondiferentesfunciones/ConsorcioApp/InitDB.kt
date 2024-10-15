package com.example.menucondiferentesfunciones.ConsorcioApp

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class InitDB:SQLiteOpenHelper(appConfig.CONTEXTO, "consorcio.db", null, 1) {
    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL(
            "create table tb_docente"+
                    "("+
                    "cod integer primary key autoincrement,"+
                    "nom varchar(30),"+
                    "pat varchar(30),"+
                    "mat varchar(30),"+
                    "sexo varchar(30),"+
                    "sue double,"+
                    "hijos int"+
                    ")"
        )

        p0.execSQL("insert into tb_docente values(null,'Ana','Soto','Mora','Femenino',2500.0,2)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}