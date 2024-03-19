package com.apprecupera.ventiun21dias.ui.dialogos

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.ui.musica.MusicaActivity

class GrabacionDialogo4 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.grabacion_dialogo4_layout, null)

        val txtContinuar = dialogView.findViewById<TextView>(R.id.btn_aceptar)

        // Configurar la vista de la caja de diálogo personalizada

        txtContinuar.setOnClickListener{
            val intent = Intent(activity, MusicaActivity::class.java)
            startActivity(intent)
            dismiss()
        }

        builder.setView(dialogView)


        return builder.create()
    }
}
