package com.apprecupera.ventiun21dias.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.apprecupera.ventiun21dias.R

class SplashActivity : AppCompatActivity() {

    private lateinit var splashImageView: ImageView

    private val IMAGES = listOf(
        R.drawable.img_inicial,
        R.drawable.img_splash_2)
    
    private val SPLASH_TIME_OUT: Long = 3000
    private var currentImageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashImageView = findViewById(R.id.img_splash)

        val handler = android.os.Handler()

        val runnable = object : Runnable {
            override fun run() {
                if (currentImageIndex < IMAGES.size) {
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


