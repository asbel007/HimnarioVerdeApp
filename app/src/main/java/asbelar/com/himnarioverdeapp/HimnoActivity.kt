package asbelar.com.himnarioverdeapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_himno.*

class HimnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_himno)

        //se coloca ? para evitar que null se haga presente
        val bundle: Bundle? = intent.extras
        val titulo=bundle?.getString("titulo")
        val descripcion=bundle?.getString("descripcion")
        textViewTitulo.text = titulo
        textViewDescripcion.text = descripcion

        btn1?.setOnClickListener({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}
