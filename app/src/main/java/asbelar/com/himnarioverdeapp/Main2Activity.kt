package asbelar.com.himnarioverdeapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import asbelar.com.himnarioverdeapp.clases.Himno
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.molde_himno.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*

class Main2Activity(
        var adapter: HimnosAdapter? = null
) : AppCompatActivity() {

    var listaDeHimnos = ArrayList<Himno>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Util para pasar los valores
        listaDeHimnos.add(Himno(R.drawable.ic_musica, "titu", "descricpicon"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, "titu2", "descricpicon2"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, "titu3", "descricpicon3"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, "titu4", "descricpicon4"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, "titu5", "descricpicon5"))

        //creando adapter para la listView
        adapter = HimnosAdapter(this, listaDeHimnos)
        idListView.adapter = adapter



        btnBuscar?.setOnClickListener({
            val intent = Intent(this, HimnoActivity::class.java)
            startActivity(intent)
        })

    }

    //necesitamos adaptar la listView con la lista
    class  HimnosAdapter(contexto: Context, var listaDeHimnos: ArrayList<Himno>): BaseAdapter(){

        var contexto: Context? = contexto

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var himno = listaDeHimnos[p0]
            var inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var miVista = inflater.inflate(R.layout.molde_himno, null)
            miVista.imageViewLogo.setImageResource(himno.imagen!!)
            miVista.textViewTitulo.text = himno.titulo!!
            miVista.textViewDescripcion.text = himno.descripcion!!

            //retornara un item de la listView
            return miVista

        }

        override fun getItem(p0: Int): Any {
            //obtendra cada fila de la lista
            return listaDeHimnos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            //retornara el tamaño de la lista
            return listaDeHimnos.size
        }
    }
}


        /*
        listaDeHimnos.add(Himno(R.drawable.activity_intent, "titu", "descricpicon"))
        listaDeHimnos.add(Himno(R.drawable.activity_intent, "titu2", "descricpicon2"))
        listaDeHimnos.add(Himno(R.drawable.activity_intent, "titu3", "descricpicon3"))
        listaDeHimnos.add(Himno(R.drawable.activity_intent, "titu4", "descricpicon4"))
        listaDeHimnos.add(Himno(R.drawable.activity_intent, "titu5", "descricpicon5"))
        */

