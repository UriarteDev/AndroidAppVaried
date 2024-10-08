package com.example.menucondiferentesfunciones.IMCApp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menucondiferentesfunciones.IMCApp.IMCActivity.Companion.IMC_KEY
import com.example.menucondiferentesfunciones.R

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners(){
        btnRecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text= result.toString()
        when(result){
            in 0.00..18.50->{
                tvResult.text = getString(R.string.tBajoPeso)
                tvDescription.text = getString(R.string.dBajoPeso)
            }
            in 18.51..24.99->{
                tvResult.text = getString(R.string.tPesoNormal)
                tvDescription.text = getString(R.string.dPesoNormal)
            }
            in 25.00..29.99->{
                tvResult.text = getString(R.string.tSobrePeso)
                tvDescription.text = getString(R.string.dSobrePeso)
            }
            in 30.00..99.99->{
                tvResult.text = getString(R.string.tObesidad)
                tvDescription.text = getString(R.string.dObesidad)
            }
            else ->{
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents(){
        tvResult=findViewById(R.id.tvResult)
        tvIMC=findViewById(R.id.tvIMC)
        tvDescription=findViewById(R.id.tvDescription)
        btnRecalculate=findViewById(R.id.btnReCalculate)
    }
}