package com.apprecupera.ventiun21dias.ui.musica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.data.Cancion

class MusicaAdapter(private val canciones: List<Cancion>,
                    private var listener: OnItemClickListener):
    RecyclerView.Adapter<MusicaAdapter.ItemViewHolder>(){

    private var selectedItemPosition = RecyclerView.NO_POSITION

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val numero: TextView = itemView.findViewById(R.id.txt_numero)
        val nombre: TextView = itemView.findViewById(R.id.txt_nombre)
        val autor: TextView = itemView.findViewById(R.id.txt_autor)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                selectedItemPosition = position
                notifyDataSetChanged() // Notifica al adaptador que se ha cambiado la selección
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_musica, parent, false)
        return this.ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val cancion = canciones[position]
        holder.numero.text = cancion.numero
        holder.nombre.text = cancion.title
        holder.autor.text = cancion.artist

        // Cambiar el color de fondo del elemento según su posición y si está seleccionado o no
        if (position == selectedItemPosition) {
            holder.itemView.setBackgroundResource(R.drawable.edit_rectangular_lleno)
        } else {
            holder.itemView.setBackgroundResource(R.drawable.edit_redondo_largo)
        }
    }

    override fun getItemCount(): Int {
        return canciones.size
    }

    fun setSelectedItem(position: Int) {
        selectedItemPosition = position
        notifyDataSetChanged()
    }
}