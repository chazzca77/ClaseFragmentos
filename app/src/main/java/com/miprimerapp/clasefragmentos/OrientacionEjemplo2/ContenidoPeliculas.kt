package com.miprimerapp.clasefragmentos.OrientacionEjemplo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.miprimerapp.clasefragmentos.R

/**
 * A simple [Fragment] subclass.
 */
class ContenidoPeliculas : Fragment() {

    var vista:View? = null

    //Siempre que se muestre este fragmento mandaremos la función cambiar foto para mostrar contenido
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_contenido_peliculas, container, false)
        cambiarFoto()
        return  vista
    }

    //función que nos sirve para regresar un fragmento ContenidoPeliculas con un argumento en este caso el index (posicion de nuestro listview)
    fun nuevaInstancia(index:Int):ContenidoPeliculas{
        val f = ContenidoPeliculas()

        val args = Bundle()
        args.putInt("INDEX",index)
        f.arguments = args

        return f
    }

    //Obtener el index de los argumentos
    fun obtenerIndex():Int{
        val index = arguments?.getInt("INDEX",0)!!
        return index
    }

    //Agregar la foto de nuestro modelo al imageview
    fun cambiarFoto(){
        val foto = vista?.findViewById<ImageView>(R.id.imgFoto)
        foto?.setImageResource(ListaPeliculas.peliculas?.get(obtenerIndex())?.imagen!!)

    }


}
