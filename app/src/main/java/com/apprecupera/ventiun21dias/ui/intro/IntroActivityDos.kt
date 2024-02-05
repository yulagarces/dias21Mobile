package com.apprecupera.ventiun21dias.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.apprecupera.ventiun21dias.R

class IntroActivityDos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_dos)

        val imageInicioTres = findViewById<ImageView>(R.id.img_inicio2_3)

        imageInicioTres.setOnClickListener {
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }
    }
}