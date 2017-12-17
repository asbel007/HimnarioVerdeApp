package asbelar.com.himnarioverdeapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import android.content.Intent
import android.widget.Toast
import asbelar.com.himnarioverdeapp.Main2Activity
import asbelar.com.himnarioverdeapp.R

class MainFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        btnAHimnos?.setOnClickListener({
            val intent = Intent(this.activity, Main2Activity::class.java)
            startActivity(intent)
        })
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_main, container, false)

    }
    /*
    fun controlador(){
        val intent = Intent()
        intent.setClass(this.context, Main2Activity :: class.java)
        startActivity(intent)
    }
import android.widget.Toast
    */

}