package com.apprecupera.ventiun21dias.ui.subcategorias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.apprecupera.ventiun21dias.R
import com.apprecupera.ventiun21dias.ui.grabacion.GrabacionActivity
import com.apprecupera.ventiun21dias.ui.intro.AbrirPortalActivity


class SubcategoriasActivity : AppCompatActivity(),  SubcategoriaAdaptador.OnItemSelectionChangedListener {
    private lateinit var tituloCategoria: String
    private lateinit var subtituloCategoriaS: String
    private lateinit var subtituloCategoriaI: String
    private lateinit var textoSeleccionado: String
    private lateinit var txtSubtitulo: TextView
    private lateinit var txtTitulo: TextView
    private lateinit var txtSubtitulo1: TextView
    private lateinit var txtSubtitulo2: TextView
    private lateinit var imgFlechaI: ImageView
    private lateinit var imgFlechaD: ImageView
    private lateinit var icRecomendacion: ImageView
    private lateinit var txtSubtituloAbajo: TextView
    private lateinit var txtRecomendaciones: TextView
    private lateinit var txtConsecutivo: TextView
    private lateinit var txtNumero: TextView
    private lateinit var rvRecomendaciones: RecyclerView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subcategorias)

        textoSeleccionado = intent.getStringExtra("texto_seleccionado").toString()
        tituloCategoria = intent.getStringExtra("categoria").toString()
        subtituloCategoriaS = intent.getStringExtra("titulo1").toString()
        subtituloCategoriaI = intent.getStringExtra("titulo2").toString()

        txtTitulo = findViewById(R.id.txt_cat_titulo)
        txtSubtitulo = findViewById(R.id.txt_sub_titulo)
        txtSubtitulo1 = findViewById(R.id.txt_cat_subtitulo1)
        txtSubtitulo2 = findViewById(R.id.txt_cat_subtitulo2)
        imgFlechaI = findViewById(R.id.img_flechai)
        imgFlechaD = findViewById(R.id.img_flechad)
        txtSubtituloAbajo = findViewById(R.id.txt_elige_tus)
        icRecomendacion = findViewById(R.id.ic_recomendacion)
        txtRecomendaciones = findViewById(R.id.txt_recomendaciones)
        txtConsecutivo = findViewById(R.id.txt_consecutivo)
        txtNumero = findViewById(R.id.txt_numero)
        rvRecomendaciones = findViewById(R.id.rv_recomendaciones)


        txtSubtitulo.text = textoSeleccionado
        txtTitulo.text = tituloCategoria
        txtSubtitulo1.text= subtituloCategoriaS
        txtSubtitulo2.text = subtituloCategoriaI

        validarCategoria()

        val listaSubcategoria =  crearListaSubcategorias(textoSeleccionado)
        val adapter = SubcategoriaAdaptador(getApplicationContext(), listaSubcategoria?: emptyList(), tituloCategoria, this)
        rvRecomendaciones.adapter = adapter
        adapter.actualizarLista(listaSubcategoria?: emptyList())
        rvRecomendaciones.layoutManager = LinearLayoutManager(this)
    }

    fun validarCategoria(){
        if (tituloCategoria.equals("Sanar")){
            txtTitulo.setTextColor(getColor(R.color.tab_sanar_sel))
            txtSubtitulo.setTextColor(getColor(R.color.tab_superar_sel))
            txtSubtitulo.setBackgroundResource(R.drawable.background_sub_sanar)
            txtSubtitulo1.setTextColor(getColor(R.color.sub_titulo1_sanar))
            txtSubtitulo2.setTextColor(getColor(R.color.sub_titulo1_sanar))
            imgFlechaI.setImageResource(R.drawable.img_flechai_sanar)
            imgFlechaD.setImageResource(R.drawable.img_flechad_sanar)
            txtSubtituloAbajo.setBackgroundColor(getColor(R.color.subtituloa_sanar_fondo))
            txtSubtituloAbajo.setTextColor(getColor(R.color.subtituloa_sanar_letra))
            icRecomendacion.setColorFilter(ContextCompat.getColor(this, R.color.sub_icono_sanar),android.graphics.PorterDuff.Mode.SRC_IN )
            txtRecomendaciones.setTextColor(getColor(R.color.sub_icono_sanar))
            txtConsecutivo.setTextColor(getColor(R.color.sub_icono_sanar))
            txtNumero.setTextColor(getColor(R.color.sub_numero_sanar))

        }
        else if(tituloCategoria.equals("Superar")){
            txtTitulo.setTextColor(getColor(R.color.titulo_superar_sub))
            txtSubtitulo.setTextColor(getColor(R.color.sub_subtitulo_superar))
            txtSubtitulo.setBackgroundResource(R.drawable.background_sub_superar)
            txtSubtitulo1.setTextColor(getColor(R.color.sub_titulo1_sanar))
            txtSubtitulo2.setTextColor(getColor(R.color.sub_titulo1_sanar))
            imgFlechaI.setImageResource(R.drawable.img_flechai_superar)
            imgFlechaD.setImageResource(R.drawable.img_flechad_superar)
            txtSubtituloAbajo.setBackgroundColor(getColor(R.color.subtituloa_superar_fondo))
            txtSubtituloAbajo.setTextColor(getColor(R.color.subtituloa_superar_letra))
            icRecomendacion.setColorFilter(ContextCompat.getColor(this, R.color.sub_icono_superar),android.graphics.PorterDuff.Mode.SRC_IN )
            txtRecomendaciones.setTextColor(getColor(R.color.sub_icono_superar))
            txtConsecutivo.setTextColor(getColor(R.color.sub_icono_superar))
            txtNumero.setTextColor(getColor(R.color.sub_numero_superar))
        }
        else if(tituloCategoria.equals("Paz mental")){
            txtTitulo.setTextColor(getColor(R.color.sub_titulo_paz))
            txtSubtitulo.setBackgroundResource(R.drawable.subcategoria_paz_fondo)
            txtSubtitulo.setTextColor(getColor(R.color.sub_subtitulo_paz))
            txtSubtitulo1.setTextColor(getColor(R.color.sub_titulo1_paz))
            txtSubtitulo2.setTextColor(getColor(R.color.sub_titulo1_paz))
            imgFlechaI.setImageResource(R.drawable.img_flechai_paz)
            imgFlechaD.setImageResource(R.drawable.img_flechad_paz)
            txtSubtituloAbajo.setBackgroundColor(getColor(R.color.subtituloa_paz_fondo))
            txtSubtituloAbajo.setTextColor(getColor(R.color.subtituloa_paz_letra))
            icRecomendacion.setColorFilter(ContextCompat.getColor(this, R.color.sub_icono_paz),android.graphics.PorterDuff.Mode.SRC_IN )
            txtRecomendaciones.setTextColor(getColor(R.color.sub_icono_paz))
            txtConsecutivo.setTextColor(getColor(R.color.sub_numero_paz))
            txtNumero.setTextColor(getColor(R.color.sub_icono_paz))
        }
        else if(tituloCategoria.equals("Diferencia")){
            txtTitulo.setTextColor(getColor(R.color.sub_titulo_dif))
            txtSubtitulo.setBackgroundResource(R.drawable.subcategoria_dif_fondo)
            txtSubtitulo.setTextColor(getColor(R.color.sub_subtitulo_dif))
            txtSubtitulo1.setTextColor(getColor(R.color.sub_titulo1_dif))
            txtSubtitulo2.setTextColor(getColor(R.color.sub_titulo1_dif))
            imgFlechaI.setImageResource(R.drawable.img_flechai_sanar)
            imgFlechaD.setImageResource(R.drawable.img_flechad_sanar)
            txtSubtituloAbajo.setBackgroundColor(getColor(R.color.subtituloa_dif_fondo))
            txtSubtituloAbajo.setTextColor(getColor(R.color.subtituloa_dif_letra))
            icRecomendacion.setColorFilter(ContextCompat.getColor(this, R.color.sub_icono_dif),android.graphics.PorterDuff.Mode.SRC_IN )
            txtRecomendaciones.setTextColor(getColor(R.color.sub_icono_dif))
            txtConsecutivo.setTextColor(getColor(R.color.sub_numero_dif))
            txtNumero.setTextColor(getColor(R.color.sub_icono_dif))
        }
        else if(tituloCategoria.equals("Atraer")){
            txtTitulo.setTextColor(getColor(R.color.sub_titulo_atraer))
            txtSubtitulo.setBackgroundResource(R.drawable.subcategoria_atraer_fondo)
            txtSubtitulo.setTextColor(getColor(R.color.sub_subtitulo_atraer))
            txtSubtitulo1.setTextColor(getColor(R.color.sub_titulo1_atraer))
            txtSubtitulo2.setTextColor(getColor(R.color.sub_titulo1_atraer))
            imgFlechaI.setImageResource(R.drawable.img_flechai_atraer)
            imgFlechaD.setImageResource(R.drawable.img_flechad_atraer)
            txtSubtituloAbajo.setBackgroundColor(getColor(R.color.subtituloa_atraer_fondo))
            txtSubtituloAbajo.setTextColor(getColor(R.color.subtituloa_atraer_letra))
            icRecomendacion.setColorFilter(ContextCompat.getColor(this, R.color.sub_icono_atraer),android.graphics.PorterDuff.Mode.SRC_IN )
            txtRecomendaciones.setTextColor(getColor(R.color.sub_icono_atraer))
            txtConsecutivo.setTextColor(getColor(R.color.sub_icono_atraer))
            txtNumero.setTextColor(getColor(R.color.sub_numero_atraer))
        }



    }
    fun crearListaSubcategorias(title: String): List<String>{
        return when(title){
            "Sanar" -> listOf<String>("Mi linaje", "Mi autoestima", "Mi Madre", "Mi Padre", "Mi Pareja",
                "Mi Salud", "El abuso - maltrato", "La infidelidad")
            "Superar" -> listOf<String>("Un ser querido", "Una pareja", "Un trabajo", "Un@ hij@", "Una mascota")
            "Paz mental" -> listOf<String>("Suelto la depresión","Suelto la ansiedad", "Suelto mi orgullo",
                "Suelto el rencor", "Suelto el estrés", "Suelto el pasado", "Suelto la anorexia",
                "Suelto las adiciones", "Claustrofobia")
            "Atraer" -> listOf<String>("El Amor","La Salud","El Dinero","El Éxito","La disciplina",
                "El Cuerpo que Quiero", "Hablar en Público")
            "Diferencia" -> listOf<String>("LGTBIQ+", "Género","Racial","Discapacidad",
                "Desplazamiento","Reincorporados", "Afronto el Bullying")
            else -> listOf<String>("Uno","Dos","Tres","Cuatro", "Cinco", "Seis", "Siete", "Ocho")
        }
    }
    // Método para manejar los cambios en la selección de elementos
    override fun onSelectionChanged(selectedItemCount: Int) {
        // Actualizar el número de elementos seleccionados en tu actividad
        // Por ejemplo, puedes mostrar el número en un TextView
        var consecutivo : Int = selectedItemCount
        txtConsecutivo.text = consecutivo.toString()
        if(consecutivo == 4){
            val intent = Intent(this, GrabacionActivity::class.java)
            startActivity(intent)
        }
    }
}