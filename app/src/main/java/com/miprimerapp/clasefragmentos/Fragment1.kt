package com.miprimerapp.clasefragmentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_1.view.*
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 */
class Fragment1 : Fragment() {

    //Creamos una variable global para utilizar nuestra interfaz
    var listener:NombreListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Es necesario asignara nuestro inflater y asignarla a una variable para poder manipular el contenido de nuestro fragmento (views)
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        //Para acceder a los elementos del view utilizamos nuestra variable view.btnFrag
        view.btnFrag.setOnClickListener {
            //Toast.makeText(view.context,"${view.edtFrag.text}",Toast.LENGTH_SHORT).show()
            listener?.obtenerNombre("${view.edtFrag.text}")
        }
        return view
    }

    //Interfaz para conectar fragment con activity
    interface NombreListener{
        fun obtenerNombre(nombre:String){}
    }

    //Método del ciclo de vida de un fragmento para inicializar nuestra interfaz
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as NombreListener
        }catch (e:ClassCastException){
            throw ClassCastException(context.toString() + "debes implementar una interfaz")
        }
    }






}
