package com.apprecupera.ventiun21dias.ui.categorias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apprecupera.ventiun21dias.R


class AfirmacionesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
       // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.afirmaciones_fragment, container, false)
        //Recibir el listado correcto
        val listaCategoria = arguments?.getStringArrayList("listadoCategoria")
        val categoria = arguments?.getString("categoria").toString()
        // Configurar el RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_categorias)
        val adapter = CategoriaAdaptador(requireContext(), listaCategoria?: emptyList(), categoria)
        recyclerView.adapter = adapter
        adapter.actualizarLista(listaCategoria?: emptyList())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}