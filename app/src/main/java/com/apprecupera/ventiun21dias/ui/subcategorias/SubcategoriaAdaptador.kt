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

class SubcategoriaAdaptador(private val context: Context, private var itemList: List<String>, private val categoria: String) :
    RecyclerView.Adapter<SubcategoriaAdaptador.ItemViewHolder>() {
    private var selectedItem = RecyclerView.NO_POSITION
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val itemNameTextView: TextView = itemView.findViewById(R.id.txt_subcategoria)
        val itemRb: ImageView = itemView.findViewById(R.id.rb_subcategoria)
        val linear: LinearLayout = itemView.findViewById(R.id.linear_subitem)

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
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategoria_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val currentItem = itemList[position]
        holder.itemNameTextView.text = currentItem

        holder.itemNameTextView.setOnClickListener{
            selectedItem = position
            notifyDataSetChanged()
        }
        if(categoria.equals("Sanar")){
            if(selectedItem == position){
                holder.linear.setBackgroundResource(R.drawable.background_subitem_sanar_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_sel)
            }
            else{
                holder.linear.setBackgroundResource(R.drawable.background_subitem_sanar_no_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_no_sel)
            }
        }
        else if(categoria.equals("Superar")){
            if(selectedItem == position){
                holder.linear.setBackgroundResource(R.drawable.background_subitem_superar_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_sel)
            }
            else{
                holder.linear.setBackgroundResource(R.drawable.background_subitem_superar_no_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_no_sel)
            }
        }
        else if(categoria.equals("Diferencia")){
            if(selectedItem == position){
                holder.linear.setBackgroundResource(R.drawable.background_subitem_dif_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_sel)
            }
            else{
                holder.linear.setBackgroundResource(R.drawable.background_subitem_dif_no_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_no_sel)
            }
        }
        else if(categoria.equals("Paz mental")){
            if(selectedItem == position){
                holder.linear.setBackgroundResource(R.drawable.background_subitem_paz_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_sel)
            }
            else{
                holder.linear.setBackgroundResource(R.drawable.background_subitem_paz_no_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_no_sel)
            }
        }
        else if(categoria.equals("Atraer")){
            if(selectedItem == position){
                holder.linear.setBackgroundResource(R.drawable.background_subitem_atraer_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_sel)
            }
            else{
                holder.linear.setBackgroundResource(R.drawable.background_subitem_atraer_no_sel)
                holder.itemRb.setImageResource(R.drawable.img_rb_no_sel)
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
