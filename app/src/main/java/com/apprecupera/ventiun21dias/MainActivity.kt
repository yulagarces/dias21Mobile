package com.apprecupera.ventiun21dias

import ViewPagerAdapterCategorias
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.viewpager.widget.ViewPager
import com.apprecupera.ventiun21dias.ui.categorias.AfirmacionesFragment
import com.apprecupera.ventiun21dias.ui.categorias.AudiosFragment
import com.apprecupera.ventiun21dias.ui.categorias.MusicaFragment
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    private lateinit var drawer_layout: DrawerLayout
    private lateinit var nav_view: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var tituloCategoria: String
    private lateinit var subtituloCategoriaS: String
    private lateinit var subtituloCategoriaI: String
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private var colorNormal: Int = 0
    private var colorSeleccionado: Int = 0
    private lateinit var bannerImage: ImageView
    private lateinit var adapter: ViewPagerAdapterCategorias
    private lateinit var titulo: TextView
    private lateinit var subtituloSuperior: TextView
    private lateinit var subtituloInferior: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer_layout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this,drawer_layout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.mipmap.mnu_hamburguesa)
        supportActionBar?.title = ""

        //Navigation Drawer
        nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setItemTextAppearance(R.style.DrawerItemStyle)

        toolbar.setNavigationOnClickListener {
            drawer_layout.openDrawer(nav_view)}
        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_universo -> {
                    // Manejar la selección del ítem de inicio
                    Toast.makeText(this, "Universo", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_grabacion -> {
                    // Manejar la selección del ítem de galería
                    Toast.makeText(this, "Grabación", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_notificaciones -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_volumen -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_psicorappi -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_carrito -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_calendario -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_recompensas -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_amigos -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_pagina -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_problema -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                R.id.nav_cerrar -> {
                    // Manejar la selección del ítem de presentación
                    true
                }

                else -> false
            }
        }

        //TabLayout
        tabLayout = findViewById<TabLayout>(R.id.tab_categoria)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        //Configuración de títulos
        titulo = findViewById(R.id.txt_titulo)
        subtituloSuperior = findViewById(R.id.txt_subtitulo_superior)
        subtituloInferior = findViewById(R.id.txt_subtitulo_inferior)

        //Configuración de colores
        tituloCategoria = intent.getStringExtra("categoria").toString()
        subtituloCategoriaS = intent.getStringExtra("subtitulo1").toString()
        subtituloCategoriaI = intent.getStringExtra("subtitulo2").toString()

        //Banner
        bannerImage = findViewById<ImageView>(R.id.img_banner)
        validarCategoria(tituloCategoria)

        // Configurar el adaptador de fragmentos
        adapter = ViewPagerAdapterCategorias(supportFragmentManager)
        adapter.addFragment(AfirmacionesFragment(), "Afirmaciones")
        adapter.addFragment(MusicaFragment(), "Música de Fondo")
        adapter.addFragment(AudiosFragment(), "Mis audios")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        Toast.makeText(this, "Esta es la categoría" + tituloCategoria, Toast.LENGTH_SHORT).show()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawer_layout.openDrawer(nav_view)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    fun validarCategoria(tituloTemp: String) {
        if (tituloTemp.equals("Sanar")) {
            colorNormal = ContextCompat.getColor(this, R.color.tab_sanar_no_sel)
            colorSeleccionado = ContextCompat.getColor(this, R.color.tab_sanar_sel)
            tabLayout.setTabTextColors(colorNormal, colorSeleccionado)
            tabLayout.setBackgroundColor(getColor(R.color.tab_sanar_fondo))
            tabLayout.setSelectedTabIndicatorColor(getColor(R.color.tab_sanar_sel))
            bannerImage.setImageResource(R.drawable.img_banner_sanar)
            titulo.text = tituloCategoria
            titulo.setTextColor(Color.GREEN)
            subtituloSuperior.text = subtituloCategoriaS
            subtituloInferior.text = subtituloCategoriaI
        }
    }
}