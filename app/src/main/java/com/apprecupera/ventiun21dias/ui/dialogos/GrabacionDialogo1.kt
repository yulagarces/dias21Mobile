package com.apprecupera.ventiun21dias.ui.dialogos

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.ui.grabacion.GrabacionActivity

class GrabacionDialogo1 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.grabacion_dialogo1_layout, null)
        val txtContinuar = dialogView.findViewById<TextView>(R.id.btn_aceptar)

        // Configurar la vista de la caja de diálogo personalizada

        txtContinuar.setOnClickListener{
            dismiss()
            // Abre el siguiente diálogo
            (requireActivity() as GrabacionActivity).abrirDialogo2()

        }
        builder.setView(dialogView)


        return builder.create()
    }

    fun onContinuarClicked(view: View) {
        val dialogo = GrabacionDialogo2()
        dialogo.show(requireFragmentManager(), "SegundoDialogo")
    }
}
