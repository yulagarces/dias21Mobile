package com.apprecupera.ventiun21dias.ui.subcategorias
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apprecupera.ventiun21dias.R

class SubcategoriaAdaptador(private val context: Context, private var itemList: List<String>, private val categoria: String,
                            private val onItemSelectionChangedListener: OnItemSelectionChangedListener) :
    RecyclerView.Adapter<SubcategoriaAdaptador.ItemViewHolder>() {

    private var selectedItem = RecyclerView.NO_POSITION
    private var selectedItems = mutableListOf<Int>()

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val itemNameTextView: TextView = itemView.findViewById(R.id.txt_subcategoria)
        val itemRb: ImageView = itemView.findViewById(R.id.rb_subcategoria)
        val linear: LinearLayout = itemView.findViewById(R.id.linear_subitem)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                // Toggle selección del item
                if (selectedItems.contains(position)) {
                    selectedItems.remove(position)
                } else {
                    selectedItems.add(position)
                }
                notifyDataSetChanged()

                // Notificar al Activity sobre el cambio en las selecciones
                onItemSelectionChangedListener.onSelectionChanged(selectedItems.size)

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategoria_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val currentItem = itemList[position]
        holder.itemNameTextView.text = currentItem

        // Verificar si el item está seleccionado
        if (selectedItems.contains(position)) {
            holder.linear.setBackgroundResource(getSelectedBackgroundResource())
            holder.itemRb.setImageResource(getSelectedRadioButtonResource())
        } else {
            holder.linear.setBackgroundResource(getUnselectedBackgroundResource())
            holder.itemRb.setImageResource(getUnselectedRadioButtonResource())
        }

    }

    override fun getItemCount() = itemList.size

    // Método para actualizar la lista de categorías
    fun actualizarLista(nuevaLista: List<String>) {
        itemList = nuevaLista
        notifyDataSetChanged()
    }
    interface OnItemSelectionChangedListener {
        fun onSelectionChanged(selectedItemCount: Int)
    }

    // Métodos para obtener recursos según el estado de selección
    private fun getSelectedBackgroundResource(): Int {
        // Lógica para obtener el recurso del fondo cuando el item está seleccionado
        return when (categoria) {
            "Sanar" -> R.drawable.background_subitem_sanar_sel
            "Superar" -> R.drawable.background_subitem_superar_sel
            "Diferencia" -> R.drawable.background_subitem_dif_sel
            "Paz mental" -> R.drawable.background_subitem_paz_sel
            "Atraer" -> R.drawable.background_subitem_atraer_sel
            else -> R.drawable.background_subitem_sanar_sel
        }
    }
    private fun getUnselectedBackgroundResource(): Int {
        // Lógica para obtener el recurso del fondo cuando el item no está seleccionado
        return when (categoria) {
            "Sanar" -> R.drawable.background_subitem_sanar_no_sel
            "Superar" -> R.drawable.background_subitem_superar_no_sel
            "Diferencia" -> R.drawable.background_subitem_dif_no_sel
            "Paz mental" -> R.drawable.background_subitem_paz_no_sel
            "Atraer" -> R.drawable.background_subitem_atraer_no_sel
            else -> R.drawable.background_subitem_sanar_no_sel
        }
    }
    private fun getSelectedRadioButtonResource(): Int {
        // Lógica para obtener el recurso del botón de radio cuando el item está seleccionado
        return when (categoria) {
            "Sanar" -> R.drawable.img_rb_sel
            "Superar" -> R.drawable.img_rb_sel
            "Diferencia" -> R.drawable.img_rb_sel
            "Paz mental" -> R.drawable.img_rb_sel
            "Atraer" -> R.drawable.img_rb_sel
            else -> R.drawable.img_rb_sel
        }
    }

    private fun getUnselectedRadioButtonResource(): Int {
        // Lógica para obtener el recurso del botón de radio cuando el item no está seleccionado
        return when (categoria) {
            "Sanar" -> R.drawable.img_rb_no_sel
            "Superar" -> R.drawable.img_rb_no_sel
            "Diferencia" -> R.drawable.img_rb_no_sel
            "Paz mental" -> R.drawable.img_rb_no_sel
            "Atraer" -> R.drawable.img_rb_no_sel
            else -> R.drawable.img_rb_no_sel
        }
    }
}
