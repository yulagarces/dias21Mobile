package com.apprecupera.ventiun21dias.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.apprecupera.ventiun21dias.R

class SplashActivity : AppCompatActivity() {

    private lateinit var splashImageView: ImageView
    private lateinit var titulo: TextView
    private lateinit var subtitulo1: TextView
    private lateinit var subtitulo2: TextView


    private val IMAGES = listOf(
        R.drawable.img_inicial,
        R.drawable.img_splash_2)
    
    private val SPLASH_TIME_OUT: Long = 3000
    private var currentImageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashImageView = findViewById(R.id.img_splash)
        titulo = findViewById(R.id.txt_titulo_pantalla2)
        subtitulo1 = findViewById(R.id.txt_subtitulo_1)
        subtitulo2 = findViewById(R.id.txt_subtitulo_2)
        titulo.visibility = View.GONE
        subtitulo1.visibility = View.GONE
        subtitulo2.visibility = View.GONE

        val handler = android.os.Handler()

        val runnable = object : Runnable {
            override fun run() {
                if (currentImageIndex < IMAGES.size) {

                    titulo.visibility = View.VISIBLE
                    subtitulo1.visibility = View.VISIBLE
                    subtitulo2.visibility = View.VISIBLE
                    splashImageView.setImageResource(IMAGES[currentImageIndex])
                    currentImageIndex++
                    handler.postDelayed(this, SPLASH_TIME_OUT)
                } else {
                    // Una vez que se hayan mostrado todas las imágenes,
                    // inicia la nueva actividad
                    val intent = Intent(this@SplashActivity, IntroActivityUno::class.java)
                    startActivity(intent)
                    finish() // Finaliza la actividad del splash screen
                }
            }
        }
        handler.post(runnable)
    }
}


