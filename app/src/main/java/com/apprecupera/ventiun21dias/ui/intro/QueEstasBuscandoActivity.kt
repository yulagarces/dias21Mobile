package com.apprecupera.ventiun21dias.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.ui.categorias.CategoriasActivity

class QueEstasBuscandoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que_estas_buscando)

        val rootView = findViewById<View>(android.R.id.content)
        rootView.setOnClickListener {
            // Iniciar ActivityB al hacer clic en cualquier parte de la pantalla
            val intent = Intent(this, CategoriasActivity::class.java)
            startActivity(intent)
        }
    }
}