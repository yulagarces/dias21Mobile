package com.apprecupera.ventiun21dias.ui.categorias
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.apprecupera.ventiun21dias.R

class CategoriaAdaptador(private val context: Context, private var itemList: List<String>, private val categoria: String) :
    RecyclerView.Adapter<CategoriaAdaptador.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val itemNameTextView: TextView = itemView.findViewById(R.id.txt_categoria)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            //val intent = Intent(context, DetailActivity::class.java)
            //context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemNameTextView.text = currentItem
        if(categoria.equals("Sanar")){
            holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_sanar)
        }
        else if(categoria.equals("Superar")){
            holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_superar)
        }
        else if(categoria.equals("Diferencia")){
            holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_diferencia)
        }
        else if(categoria.equals("Paz mental")){
            holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_paz)
        }
        else if(categoria.equals("Atraer")){
            holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_atraer)
        }


    }

    override fun getItemCount() = itemList.size

    // Método para actualizar la lista de categorías
    fun actualizarLista(nuevaLista: List<String>) {
        itemList = nuevaLista
        notifyDataSetChanged()
    }
}
