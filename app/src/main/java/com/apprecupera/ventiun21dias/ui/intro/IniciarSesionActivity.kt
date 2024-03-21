package com.apprecupera.ventiun21dias.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.apprecupera.ventiun21dias.R

class IniciarSesionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        val btnIniciar = findViewById<TextView>(R.id.btn_iniciar_sesion)
        btnIniciar.setOnClickListener {
            // Iniciar ActivityB al hacer clic en cualquier parte de la pantalla
            val intent = Intent(this, AbrirPortalActivity::class.java)
            startActivity(intent)
    }
}
}