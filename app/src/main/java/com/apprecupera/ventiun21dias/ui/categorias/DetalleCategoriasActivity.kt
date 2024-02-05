package com.apprecupera.ventiun21dias.ui.categorias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.ui.grabacion.GrabacionActivity

class DetalleCategoriasActivity : AppCompatActivity() {

    lateinit var titulo: String
    lateinit var titulo1: String
    lateinit var titulo2: String
    lateinit var txtTitulo: TextView
    lateinit var txtTitulo1: TextView
    lateinit var txtTitulo2: TextView
    lateinit var imgTitulo: ImageView
    lateinit var fondoPantalla : ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sanar1)

        titulo = intent.getStringExtra("titulo").toString()
        titulo1 = intent.getStringExtra("titulo1").toString()
        titulo2 = intent.getStringExtra("titulo2").toString()

        txtTitulo1 = findViewById(R.id.txt_titulo_1)
        txtTitulo2 = findViewById(R.id.txt_titulo_2)
        imgTitulo = findViewById(R.id.img_titulo)

        fondoPantalla = findViewById<ConstraintLayout>(R.id.fondo)

        validarCategoria()

        val rootView = findViewById<View>(android.R.id.content)
        rootView.setOnClickListener {
            // Iniciar ActivityB al hacer clic en cualquier parte de la pantalla
            val intent = Intent(this, GrabacionActivity::class.java)
            startActivity(intent)
        }

    }

    fun validarCategoria(){
        if (titulo.equals("Sanar")){
            txtTitulo1.text = titulo1
            txtTitulo2.text = titulo2
            imgTitulo.setImageResource(R.drawable.titulo_sanar)
            fondoPantalla.setBackgroundResource(R.drawable.pantalla_sanar_1)
        }
        else if (titulo.equals("Superar")){
            txtTitulo1.text = titulo1
            txtTitulo2.text = titulo2
            imgTitulo.setImageResource(R.drawable.titulo_superar)
            fondoPantalla.setBackgroundResource(R.drawable.pantalla_superar)
        }

        else if (titulo.equals("Paz mental")){
            txtTitulo1.text = titulo1
            txtTitulo2.text = titulo2
            imgTitulo.setImageResource(R.drawable.titulo_paz)
            fondoPantalla.setBackgroundResource(R.drawable.pantalla_paz)
        }

        else if (titulo.equals("Diferencia")){
            txtTitulo1.text = titulo1
            txtTitulo2.text = titulo2
            imgTitulo.setImageResource(R.drawable.titulo_diferencia)
            fondoPantalla.setBackgroundResource(R.drawable.pantalla_diferencia)
        }

        else if (titulo.equals("Atraer")){
            txtTitulo1.text = titulo1
            txtTitulo2.text = titulo2
            imgTitulo.setImageResource(R.drawable.titulo_atraer)
            fondoPantalla.setBackgroundResource(R.drawable.pantalla_atraer)
        }
        }


}