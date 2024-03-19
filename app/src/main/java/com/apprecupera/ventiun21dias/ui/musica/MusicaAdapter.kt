package com.apprecupera.ventiun21dias.ui.musica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.data.Cancion

class MusicaAdapter(private val canciones: List<Cancion>, private val listener: OnItemClickListener):
    RecyclerView.Adapter<MusicaAdapter.ViewHolder>(){

    inner class MusicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)

            }

        }
    }

        interface OnItemClickListener {
            fun onItemClick(position: Int)
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numero: TextView = itemView.findViewById(R.id.txt_numero)
        val nombre: TextView = itemView.findViewById(R.id.txt_nombre)
        val autor: TextView = itemView.findViewById(R.id.txt_autor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_musica, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cancion = canciones[position]
        holder.numero.text = cancion.numero
        holder.nombre.text = cancion.title
        holder.autor.text = cancion.artist


    }

    override fun getItemCount(): Int {
        return canciones.size
    }
}