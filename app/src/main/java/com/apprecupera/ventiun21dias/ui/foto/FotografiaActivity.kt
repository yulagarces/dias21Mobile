package com.apprecupera.ventiun21dias.ui.foto

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import com.apprecupera.ventiun21dias.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FotografiaActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var btnFoto: ImageView

    private val REQUEST_IMAGE_CAPTURE = 1
    private val CAMERA_PERMISSION_CODE = 101
    private var currentPhotoPath: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fotografia)

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        btnFoto = findViewById(R.id.btn_foto)
        btnFoto.setOnClickListener {
            dispatchTakePictureIntent()

        // Método para verificar el permiso de acceso a la cámara, de no existir debe solicitarse
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_CODE
            )
        } else {
            setupImageViewClickListener()
        }

        }

    }
    private fun setupImageViewClickListener() {
        btnFoto.setOnClickListener {
            dispatchTakePictureIntent()
        }
    }

    private fun saveImageToStorage(imageBitmap: Bitmap): Uri? {
        val imagesDir = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "photos")
        if (!imagesDir.exists()) {
            imagesDir.mkdirs()
        }
        //val imageFile = File(imagesDir, "photo_${System.currentTimeMillis()}.jpg")
        val imageFile = File(imagesDir, "mi_foto.jpg")
              Log.e("Foto", "Esta es la ubicación: "+  imageFile)
        try {
            val stream: OutputStream = FileOutputStream(imageFile)
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return FileProvider.getUriForFile(this, "com.example.android.fileprovider", imageFile)
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Crea el nombre del archivo de imagen
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "mi_foto.jpg")
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefijo */
            ".jpg", /* sufijo */
            storageDir /* directorio */
        ).apply {
            // Guarda la ruta de archivo
            currentPhotoPath = absolutePath
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            // Obtener la foto tomada como un bitmap
            val imageBitmap = data?.extras?.get("data") as Bitmap
            // Establecer el bitmap en el ImageView
            btnFoto.setImageBitmap(imageBitmap)
            val savedImageUri = saveImageToStorage(imageBitmap)
            if (savedImageUri != null) {
                val sharedPreferences = getSharedPreferences("mi_foto", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("miFotoUri", savedImageUri.toString())
                editor.apply()
            }

        }
    }
}