package com.apprecupera.ventiun21dias.ui.musica

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.apprecupera.ventiun21dias.R

class MusicaDialogo : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.musica_dialogo_layout, null)

        val txtContinuar = dialogView.findViewById<TextView>(R.id.btn_aceptar)
        val txtCancelar = dialogView.findViewById<TextView>(R.id.btn_cancelar)

        // Configurar la vista de la caja de diálogo personalizada

        txtContinuar.setOnClickListener{
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
}
