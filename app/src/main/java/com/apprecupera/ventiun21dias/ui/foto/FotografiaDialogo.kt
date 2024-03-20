package com.apprecupera.ventiun21dias.ui.foto

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import androidx.fragment.app.DialogFragment
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.ui.musica.MusicaActivity
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FotografiaDialogo : DialogFragment() {
    private val REQUEST_IMAGE_CAPTURE = 1
    private var fotoPath: String? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.fotografia_dialogo_layout, null)

        val txtFoto = dialogView.findViewById<TextView>(R.id.btn_tomar_foto)
        val txtGaleria = dialogView.findViewById<TextView>(R.id.btn_seleccionar_galeria)
        val txtCancelar = dialogView.findViewById<TextView>(R.id.btn_cancelar)

        // Configurar la vista de la caja de diálogo personalizada

        txtFoto.setOnClickListener{
            val intent = Intent(activity, MusicaActivity::class.java)
            startActivity(intent)
            dismiss()
        }
        txtGaleria.setOnClickListener{
            val intent = Intent(activity, MusicaActivity::class.java)
            startActivity(intent)
            dismiss()
        }
        txtCancelar.setOnClickListener{
            dismiss()
        }
        builder.setView(dialogView)


        return builder.create()
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Crea el nombre del archivo de imagen
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefijo */
            ".jpg", /* sufijo */
            storageDir /* directorio */
        ).apply {
            // Guarda la ruta de archivo
            fotoPath = absolutePath
        }
    }
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Verifica si hay una aplicación de cámara disponible para manejar la solicitud
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Crea el archivo de imagen donde se guardará la foto
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Manejar error de creación de archivo
                    null
                }
                // Continúa solo si se pudo crear el archivo
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "com.example.android.fileprovider",
                        it
                    )
                    // Asigna la ubicación del archivo de imagen para que la cámara la guarde
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    // Inicia la actividad de la cámara
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }
}
