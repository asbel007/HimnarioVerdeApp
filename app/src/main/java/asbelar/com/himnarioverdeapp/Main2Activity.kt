package asbelar.com.himnarioverdeapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
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
        listaDeHimnos.add(Himno(R.drawable.ic_musica, 1, "t1","t2","a1","a2"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, 1, "t12","t22","a12","a22"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, 1, "t13","t23","a13","a23"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, 1, "t14","t24","a14","a24"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, 1, "t15","t25","a15","a25"))
        listaDeHimnos.add(Himno(R.drawable.ic_musica, 1, "t16","t26","a16","a26"))

        //creando adapter para la listView
        adapter = HimnosAdapter(this, listaDeHimnos)
        idListView.adapter = adapter

    }


    //necesitamos un buscador de los himnos.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val buscar = menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val manejador = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        buscar.setSearchableInfo(manejador.getSearchableInfo(componentName))

        buscar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

            //cuando apretemos enter en el buscador entonces esta funcion se activara
            override fun onQueryTextSubmit(p0: String?): Boolean {
                Toast.makeText(applicationContext, p0, Toast.LENGTH_SHORT).show()
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }


    //necesitamos adaptar la listView con la lista
    class  HimnosAdapter(contexto: Context, var listaDeHimnos: ArrayList<Himno>): BaseAdapter(){

        var contexto: Context? = contexto

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var himno = listaDeHimnos[p0]
            var inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var miVista = inflater.inflate(R.layout.molde_himno, null)
            miVista.imageViewLogo.setImageResource(himno.imagen!!)
            miVista.textViewNumero.text = himno.numero!!.toString()
            miVista.textViewTituloEs.text = himno.tituloEs!!
            miVista.textViewTituloQch.text = himno.tituloQch!!


            //miVista.imageViewLogo.setOnClickListener{}
            miVista.idCuadro.setOnClickListener{

                val intent = Intent(contexto, HimnoActivity::class.java)
                //no olvides los !! para las escepciones de null, asignamos las variables a nivel global
                intent.putExtra("numero",himno.numero!!)
                intent.putExtra("tituloEs",himno.tituloEs!!)
                intent.putExtra("tituloQch",himno.tituloQch!!)
                intent.putExtra("alabanzaEs",himno.alabanzaEs!!)
                intent.putExtra("alabanzaQch",himno.alabanzaQch!!)
                intent.putExtra("coroEs",himno.coroEs!!)
                intent.putExtra("coroQch",himno.coroQch!!)
                contexto!!.startActivity(intent)
            }

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