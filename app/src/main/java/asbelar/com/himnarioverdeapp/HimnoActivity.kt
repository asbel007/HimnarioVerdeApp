package asbelar.com.himnarioverdeapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_himno.*
import kotlinx.android.synthetic.main.molde_himno.*

class HimnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_himno)

        //se coloca ? para evitar que null se haga presente
        val bundle: Bundle? = intent.extras
        val numero=bundle?.getString("numero")
        val tituloEs=bundle?.getString("tituloEs")
        val alabanzaEs=bundle?.getString("alabanzaEs")
        textViewNumeroH.text = numero
        textViewTituloEsH.text = tituloEs
        textViewAlabanzaEsH.text = alabanzaEs

        btn1?.setOnClickListener({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}
