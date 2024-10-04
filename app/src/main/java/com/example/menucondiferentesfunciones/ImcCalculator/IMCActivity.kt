package com.example.menucondiferentesfunciones.ImcCalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.KeyEventDispatcher.Component
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menucondiferentesfunciones.R

class IMCActivity:AppCompatActivity() {

    private var isMaleSelected:Boolean=true
    private var isFemaleSelected:Boolean=false

    private lateinit var cardMale:CardView
    private lateinit var cardFemale:CardView
            
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
    }
}