package com.apprecupera.ventiun21dias.ui.categorias
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.ui.subcategorias.SubcategoriasActivity

class CategoriaAdaptador(private val context: Context, private var itemList: List<String>, private val categoria: String, private val titulo1: String, private val titulo2: String) :
    RecyclerView.Adapter<CategoriaAdaptador.ItemViewHolder>() {
    private var selectedItem = RecyclerView.NO_POSITION
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val itemNameTextView: TextView = itemView.findViewById(R.id.txt_categoria)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                val selectedText = itemNameTextView.text.toString()
                val intent = Intent(context, SubcategoriasActivity::class.java).apply {
                    putExtra("texto_seleccionado", selectedText)
                    putExtra("categoria", categoria)
                    putExtra("titulo1", titulo1)
                    putExtra("titulo2", titulo2)

                }
                itemView.context.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria_layout, parent, false)
        return ItemViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val currentItem = itemList[position]

        holder.itemNameTextView.text = currentItem

        if(categoria.equals("Sanar")){
            if(selectedItem == position){
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_sanar_sel)
            }
            else{
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_sanar)
            }
        }
        else if(categoria.equals("Superar")){
            if(selectedItem == position){
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_superar_sel)
            }
            else{
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_superar)
            }
        }
        else if(categoria.equals("Diferencia")){
            if(selectedItem == position){
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_diferencia_sel)
            }
            else{
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_diferencia)
            }
        }
        else if(categoria.equals("Paz mental")){
            if(selectedItem == position){
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_paz_sel)
            }
            else{
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_paz)
            }
        }
        else if(categoria.equals("Atraer")){
            if(selectedItem == position){
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_atraer_sel)
            }
            else{
                holder.itemNameTextView.setBackgroundResource(R.drawable.background_item_atraer)
            }
        }
    }


    override fun getItemCount() = itemList.size

    // Método para actualizar la lista de categorías
    fun actualizarLista(nuevaLista: List<String>) {
        itemList = nuevaLista
        notifyDataSetChanged()
    }


}
