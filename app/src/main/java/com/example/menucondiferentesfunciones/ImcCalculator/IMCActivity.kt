package com.example.menucondiferentesfunciones.ImcCalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.KeyEventDispatcher.Component
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menucondiferentesfunciones.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class IMCActivity:AppCompatActivity() {

    private var isMaleSelected:Boolean=true
    private var isFemaleSelected:Boolean=false
    private var currentWeight:Int=70
    private var currentAge:Int=20
    private var currentHeight:Int=120

    private lateinit var cardMale:CardView
    private lateinit var cardFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnDownWeight:FloatingActionButton
    private lateinit var btnUpWeight:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var btnDownAge:FloatingActionButton
    private lateinit var btnUpAge:FloatingActionButton
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate:Button

    companion object{
        const val IMC_KEY= "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponets()
        initListeners()
        initUI()
    }

    private fun initComponets() {
        cardMale=findViewById(R.id.cardMale)
        cardFemale=findViewById(R.id.cardFemale)
        tvHeight=findViewById(R.id.tvHeight)
        rsHeight=findViewById(R.id.rsHeight)
        btnDownWeight=findViewById(R.id.btnDownWeight)
        btnUpWeight=findViewById(R.id.btnUpWeight)
        tvWeight=findViewById(R.id.tvWeight)
        btnDownAge=findViewById(R.id.btnDownAge)
        btnUpAge=findViewById(R.id.btnUpAge)
        tvAge=findViewById(R.id.tvAge)
        btnCalculate=findViewById(R.id.btnCalculate)
    }
    private fun initListeners() {
        cardMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        cardFemale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df=DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight CM"
        }
        btnUpWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnDownWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnUpAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnDownAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent=Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df=DecimalFormat("#.##")
        val imc = currentWeight/(currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()

    }

    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }
    private fun setAge(){
        tvAge.text = currentAge.toString()
    }

    private fun changeGender(){
        isMaleSelected=!isMaleSelected
        isFemaleSelected=!isFemaleSelected
    }

    private fun setGenderColor(){
        cardMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cardFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReferences =if(isSelectedComponent){
            R.color.cardSelected
        }else{
            R.color.card
        }
        return ContextCompat.getColor(this,colorReferences)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
}