package com.example.menucondiferentesfunciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menucondiferentesfunciones.IMCApp.IMCActivity
import com.example.menucondiferentesfunciones.ListApp.ListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        val btnList = findViewById<Button>(R.id.btnList)
        btnIMC.setOnClickListener { navigateToIMC() }
        btnList.setOnClickListener { navigateToList() }
    }

    private fun navigateToList() {
        val  intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMC(){
        val  intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }
}