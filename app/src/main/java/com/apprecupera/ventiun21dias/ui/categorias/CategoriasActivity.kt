package com.apprecupera.ventiun21dias.ui.categorias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.apprecupera.ventiun21dias.R

class CategoriasActivity : AppCompatActivity() {
    lateinit var categoriaSanar:ImageView
    lateinit var categoriaSuperar: ImageView
    lateinit var categoriaPaz: ImageView
    lateinit var categoriaDiferencia: ImageView
    lateinit var categoriaAtraer: ImageView

    lateinit var titulo1: String
    lateinit var titulo2: String
    lateinit var titulo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        categoriaSanar = findViewById<ImageView>(R.id.categoria_sanar)
        categoriaSanar.setOnClickListener {
            sanar()
        }

        categoriaSuperar = findViewById<ImageView>(R.id.categoria_superar)
        categoriaSuperar.setOnClickListener {
            superar()
        }

        categoriaPaz = findViewById<ImageView>(R.id.categoria_paz)
        categoriaPaz.setOnClickListener {
            pazMental()
        }

        categoriaDiferencia = findViewById<ImageView>(R.id.categoria_diferencia)
        categoriaDiferencia.setOnClickListener {
            diferencia()
        }

        categoriaAtraer = findViewById<ImageView>(R.id.categoria_atraer)
        categoriaAtraer.setOnClickListener {
            atraer()
        }
    }

    fun sanar(){
        val intent = Intent(this, DetalleCategoriasActivity::class.java)
        titulo1 = getString(R.string.titulo_sanar_uno)
        titulo2 = getString(R.string.titulo_sanar_dos)
        titulo = getString(R.string.titulo_sanar)
        intent.putExtra("titulo", titulo)
        intent.putExtra("titulo1", titulo1)
        intent.putExtra("titulo2", titulo2)
        startActivity(intent)
    }

    fun superar(){
        val intent = Intent(this, DetalleCategoriasActivity::class.java)
        titulo1 = getString(R.string.titulo_superar_uno)
        titulo2 = getString(R.string.titulo_superar_dos)
        titulo = getString(R.string.titulo_superar)
        intent.putExtra("titulo", titulo)
        intent.putExtra("titulo1", titulo1)
        intent.putExtra("titulo2", titulo2)
        startActivity(intent)
    }

    fun pazMental(){
        val intent = Intent(this, DetalleCategoriasActivity::class.java)
        titulo1 = getString(R.string.titulo_paz_uno)
        titulo2 = getString(R.string.titulo_paz_dos)
        titulo = getString(R.string.titulo_paz)
        intent.putExtra("titulo", titulo)
        intent.putExtra("titulo1", titulo1)
        intent.putExtra("titulo2", titulo2)
        startActivity(intent)
    }

    fun diferencia(){
        val intent = Intent(this, DetalleCategoriasActivity::class.java)
        titulo1 = getString(R.string.titulo_diferencia_uno)
        titulo2 = getString(R.string.titulo_diferencia_dos)
        titulo = getString(R.string.titulo_diferencia)
        intent.putExtra("titulo", titulo)
        intent.putExtra("titulo1", titulo1)
        intent.putExtra("titulo2", titulo2)
        startActivity(intent)
    }

    fun atraer(){
        val intent = Intent(this, DetalleCategoriasActivity::class.java)
        titulo1 = getString(R.string.titulo_atraer_uno)
        titulo2 = getString(R.string.titulo_atraer_dos)
        titulo = getString(R.string.titulo_atraer)
        intent.putExtra("titulo", titulo)
        intent.putExtra("titulo1", titulo1)
        intent.putExtra("titulo2", titulo2)
        startActivity(intent)
    }
}
