package com.apprecupera.ventiun21dias.ui.musica

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.data.Cancion
import com.apprecupera.ventiun21dias.ui.dialogos.GrabacionDialogo1

class MusicaActivity : AppCompatActivity(), MusicaAdapter.OnItemClickListener {
    private lateinit var toolbar: Toolbar
    private lateinit var rvMusica: RecyclerView
    private lateinit var adaptadorMusica: MusicaAdapter
    private lateinit var btnPlay: ImageView
    private lateinit var btnSiguiente: ImageView
    private lateinit var btnAtras: ImageView
    private lateinit var btnSeleccionar: ImageView
    private lateinit var mediaPlayer: MediaPlayer
    private var contador = 0
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    var nombreCancion = ""


    private val canciones = listOf(
        Cancion("1. ", "You", "Fifty Sounds", "c1_you_fifty_sounds"),
        Cancion("2. ", "Epic Relaxing Flute Onetent", "Pixabay", "c2_epic_relaxing_flute_onetent_pixabay"),
        Cancion("3. ", "Chill Factor", "Fifty Sounds", "c3_chillf_factor_fifty_sounds"),
        Cancion("4. ", "Hare Krishna Relaxing Soulmusic", "Pixabay", "c4_hare_krishna_relaxing_soulmusic_pixabay"),
        Cancion("5. ", "Oceans of Sand", "Fifty Sounds", "c5_oceans_of_sand_fifty_sounds"),
        Cancion("6. ", "Endless Beauty Main", "Pixabay", "c6_endless_beauty_main_pixabay"),
        Cancion("7. ", "Promise", "Fifty Sounds", "c7_promise_fifty_sounds"),
        Cancion("8. ", "The Best Time", "Pixabay", "c8_the_best_time_pixabay"),
        Cancion("9. ", "Where the Light Is", "Pixabay", "c9_where_the_light_is_pixabay"),
        Cancion("10. ", "Mandarin Calmly Music", "Pixabay", "c10_mandarin_calmly_music_pixabay"),
        Cancion("11. ", "Dancing Alone", "Fifty Sounds", "c11_dancing_alone_fifty_sounds"),
        Cancion("12. ", "A Short Story", "Fifty Sounds", "c12_a_short_story_fifty_sounds"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musica)

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        btnPlay = findViewById(R.id.btn_play2)
        btnAtras = findViewById(R.id.btn_atras)
        btnSiguiente = findViewById(R.id.btn_siguiente)
        btnSeleccionar = findViewById(R.id.btn_seleccionar)
        mediaPlayer = MediaPlayer()

        sharedPreferences = getSharedPreferences("mi_cancion", Context.MODE_PRIVATE)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        rvMusica = findViewById(R.id.rv_musica)

        adaptadorMusica = MusicaAdapter(canciones, this)
        rvMusica.adapter = adaptadorMusica
        rvMusica.layoutManager = LinearLayoutManager(this)

        btnPlay.setOnClickListener{
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                btnPlay.setImageResource(R.drawable.btn_play)
            }
            else{
                mediaPlayer.start()
                btnPlay.setImageResource(R.drawable.btn_pausa_play)
                playSong()
                adaptadorMusica.setSelectedItem(contador)
            }
        }
        btnSiguiente.setOnClickListener {
            if(contador < canciones.size -1){
                contador++
                playSong()
                adaptadorMusica.setSelectedItem(contador)
            }
        }
        btnAtras.setOnClickListener {
            if(contador > 0){
                contador--
                playSong()
                adaptadorMusica.setSelectedItem(contador)
            }
        }
        btnSeleccionar.setOnClickListener {
            editor = sharedPreferences.edit()
            editor.putString("nombre_archivo", nombreCancion)
            editor.putInt("contador", contador)
            editor.apply()
            mostrarDialogo()
        }
    }

    private fun mostrarDialogo(){
        val dialogFragment = MusicaDialogo()
        dialogFragment.show(supportFragmentManager, "PrimerDialogo")
    }
    private fun playSong(){
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        nombreCancion = canciones[contador].fileName
        val resId = resources.getIdentifier(nombreCancion, "raw", "com.apprecupera.ventiun21dias")
        mediaPlayer = MediaPlayer.create(this, resId)
        mediaPlayer.start()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
    override fun onItemClick(position: Int) {
        contador = position
    }
}