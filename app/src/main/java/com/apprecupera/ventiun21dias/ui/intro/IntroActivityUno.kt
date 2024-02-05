package com.apprecupera.ventiun21dias.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.apprecupera.ventiun21dias.R

class IntroActivityUno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_uno)

        val imageInicioDos = findViewById<ImageView>(R.id.img_inicio1_2)
        Log.e("Error1", "Estoy en la primer pantalla")
        imageInicioDos.setOnClickListener {
            val intent = Intent(this, IntroActivityDos::class.java)
            startActivity(intent)
        }
    }
}