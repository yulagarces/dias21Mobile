package com.apprecupera.ventiun21dias.ui.musica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.apprecupera.ventiun21dias.R

class MusicaActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musica)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}