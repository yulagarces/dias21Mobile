package com.apprecupera.ventiun21dias.ui.dialogos

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.apprecupera.ventiun21dias.R

class GrabacionDialogo3 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.grabacion_dialogo_3_layout, null)

        // Configurar la vista de la caja de diálogo personalizada

        builder.setView(dialogView)
            .setPositiveButton("Aceptar") { dialog, _ ->
                // Acción al hacer clic en el botón Aceptar
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                // Acción al hacer clic en el botón Cancelar
                dialog.cancel()
            }

        return builder.create()
    }
}
