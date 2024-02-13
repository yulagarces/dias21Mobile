package com.apprecupera.ventiun21dias.ui.grabacion

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.ui.dialogos.GrabacionDialogo1
import java.io.File
import java.io.IOException

class GrabacionActivity : AppCompatActivity() {

    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var isRecording = false
    private lateinit var btnGrabar:ImageView
    private lateinit var btnReproducir:ImageView
    private lateinit var txtGrabarNuevamente: TextView
    private lateinit var txtAceptar: TextView
    private lateinit var txtGuiaGrabacion: TextView
    private lateinit var btnAyuda: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grabacion)

        if (!checkPermissions()) {
            requestPermissions()
        }
        txtGrabarNuevamente = findViewById<TextView>(R.id.txt_grabar_de_nuevo)
        txtGrabarNuevamente.setOnClickListener {
            cleanValues()
        }
        txtAceptar = findViewById<TextView>(R.id.img_aceptar)
        txtGuiaGrabacion = findViewById<TextView>(R.id.txt_guia_grabacion)

        btnGrabar = findViewById<ImageView>(R.id.img_grabar)
        btnGrabar.setOnClickListener {
            onRecordButtonClicked()
        }
        btnReproducir = findViewById<ImageView>(R.id.img_play)
        btnReproducir.setOnClickListener {
            onPlayButtonClicked()
        }

        btnAyuda = findViewById(R.id.img_ayuda)
        btnAyuda.setOnClickListener(){
            mostrarDialogo()
        }

    }

    private fun checkPermissions(): Boolean {
        val recordPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
        val storagePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return recordPermission == PackageManager.PERMISSION_GRANTED && storagePermission == PackageManager.PERMISSION_GRANTED
    }
    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSION_CODE)
    }

    //Botón grabar
    fun onRecordButtonClicked() {
        if (isRecording) {
            stopRecording()
        } else {
            btnGrabar.setImageResource(R.drawable.boton_grabando)
            txtGuiaGrabacion.text = getString(R.string.guia_grabacion_dos)
            startRecording()
        }
    }
    //Botón reproducir
    fun onPlayButtonClicked() {
        mediaPlayer = MediaPlayer()
        try {
            mediaPlayer?.setDataSource(getFilePath())
            mediaPlayer?.prepare()
            mediaPlayer?.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    //Grabar sonido
    private fun startRecording() {
        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            setOutputFile(getFilePath())

            try {
                prepare()
                start()
                isRecording = true
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
    //Parar grabación
    private fun stopRecording() {
        btnGrabar.setImageResource(R.drawable.boton_pausa)
        btnReproducir.visibility = View.VISIBLE
        txtAceptar.visibility = View.VISIBLE
        txtGrabarNuevamente.visibility = View.VISIBLE
        txtGuiaGrabacion.visibility = View.INVISIBLE
        mediaRecorder?.apply {
            stop()
            release()
        }
        mediaRecorder = null
        isRecording = false
    }
    private fun cleanValues(){
        btnGrabar.setImageResource(R.drawable.boton_grabar)
        btnReproducir.visibility = View.INVISIBLE
        txtAceptar.visibility = View.INVISIBLE
        txtGrabarNuevamente.visibility = View.INVISIBLE
        txtGuiaGrabacion.visibility = View.VISIBLE
        btnReproducir.visibility = View.INVISIBLE
    }

    //Obtener ruta
    private fun getFilePath(): String {

        val folder = getExternalFilesDir(null)?.absolutePath?:""
        val folderDir = File(folder)
        if (!folderDir.exists()) {
            folderDir.mkdirs()
        }
        return "$folderDir/recorded_audio.3gp"
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
        mediaPlayer = null
        mediaRecorder?.release()
        mediaRecorder = null
    }

    companion object {
        private const val PERMISSION_CODE = 101
    }

    private fun mostrarDialogo(){
        val dialogFragment = GrabacionDialogo1()
        dialogFragment.show(supportFragmentManager, "CustomDialog")
    }
}