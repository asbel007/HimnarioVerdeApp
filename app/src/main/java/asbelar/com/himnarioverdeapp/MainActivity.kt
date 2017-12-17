package asbelar.com.himnarioverdeapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import asbelar.com.himnarioverdeapp.fragments.AcercaDeFragment
import asbelar.com.himnarioverdeapp.fragments.ConfiguracionFragment
import asbelar.com.himnarioverdeapp.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Reemplace con tu propia acccion", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        // Boton que Cambia al Segundo Activity
        val btnCM = findViewById<Button>(R.id.btnContentMain)
        btnCM.text = "Entrar a Himnos"
        btnCM.setOnClickListener({
            val intent2 = Intent(this, Main2Activity::class.java)
            startActivity(intent2)
        })
        /*
        btnContentMain?.setOnClickListener({})
        */

        //implementar fragment
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        val textPrincipal = findViewById<TextView>(R.id.txtHome)
        //Para Llamar a los Fragmentos
        val fragmentManager = supportFragmentManager

        when (item.itemId) {
            R.id.nav_home -> {
                toolbar.setTitle("Principal")
                fragmentManager.beginTransaction().replace(R.id.contentMain, MainFragment()).commit()
                //manda un mensaje por un pequeño tiempo
                Toast.makeText(this,"Esto es principal", Toast.LENGTH_LONG).show()

            }
            R.id.nav_favorites -> {
                toolbar.setTitle("Favoritos")
                textPrincipal.text  = "Favoritos"

            }
            R.id.nav_donations -> {
                textPrincipal.text  = "Donaciones"
                toolbar.setTitle("Gracias por su intenciones de Donacion, pero aun estamos implementando. MUCHAS GRACIAS")
            }
            R.id.nav_remove -> {
                textPrincipal.text  = "Quitar Publicidad"
                toolbar.setTitle("Aun estamos implementando la Ventana de Quitar Publicidad")

            }
            R.id.nav_manage -> {
                textPrincipal.text  = "C"
                toolbar.setTitle("Configuraciones")
                fragmentManager.beginTransaction().replace(R.id.contentMain, ConfiguracionFragment()).commit()

            }
            R.id.nav_send -> {
                textPrincipal.text  = "Contactanos/Enviar"
                toolbar.setTitle("Contactanos")

            }
            R.id.nav_about -> {
                fragmentManager.beginTransaction().replace(R.id.contentMain, AcercaDeFragment()).commit()
                //val intent = Intent(this, Main2Activity::class.java)
                //startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
