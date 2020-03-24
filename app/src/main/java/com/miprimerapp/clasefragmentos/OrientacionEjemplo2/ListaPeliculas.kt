package com.miprimerapp.clasefragmentos.OrientacionEjemplo2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import androidx.fragment.app.FragmentTransaction
import com.miprimerapp.clasefragmentos.OrientacionEjemplo2.Models.Pelicula

import com.miprimerapp.clasefragmentos.R

/**
 * A simple [Fragment] subclass.
 */
class ListaPeliculas : Fragment() {

    /*Creamos una variable para utilizar nuestro Modelo de peliculas, el companion object
    // hace que  todo lo que pongamos dentro sea global, y pueda ser visto por otras classes*/
    companion object{
        var peliculas : ArrayList<Pelicula>? = null
    }
    var nombrePeliculas: ArrayList<String>? = null
    var lista:ListView? = null

    //Creamos variables para almacenar la posición actual y si hay los 2 fragmentos visibles
    var hayDoblePanel = false
    var posicionActual = 0

    //En este método llenamos nuestro arraylist de peliculas y asignamos un adaptador simple al listview dentro del fragment
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        peliculas = ArrayList()
        peliculas?.add(Pelicula("Pelicula 1",R.drawable.ic_launcher_background))
        peliculas?.add(Pelicula("Pelicula 2",R.drawable.ic_launcher_foreground))

        nombrePeliculas = obtenerNombrePeliculas(peliculas!!)

        var adaptador = ArrayAdapter(activity!!,
            android.R.layout.simple_list_item_activated_1,nombrePeliculas!!)
        lista = activity!!.findViewById(R.id.lista)
        lista?.adapter = adaptador

        lista?.setOnItemClickListener{ adapterView, view, i,l ->
            /*val intent = Intent(view.context,Detalles::class.java)
            intent.putExtra("IDEX",i)
            startActivity(intent)*/
            mostrarDetalles(i)
        }

        //asignamos nuestro contenedor del fragmento detalles a una variable a través de activity!!
        val frameDetalles = activity!!.findViewById<FrameLayout>(R.id.fdetalles)
        //Comparamos si es visible
        hayDoblePanel = frameDetalles != null && frameDetalles.visibility == View.VISIBLE

        //esto nos sirve en caso de que tengamos un savedInstanceState guardado de otro activity y obtener la posición actual de mi listview(la selección)
        if(savedInstanceState != null){
            posicionActual = savedInstanceState.getInt("INDEX",0)
        }
        //en caso de mostrar ambos paneles le damos la propiedad a nuestro listview de que la selección se mantenga
        //y muestro los detalles en el fragmento derecho
        if(hayDoblePanel){
            lista?.choiceMode = ListView.CHOICE_MODE_SINGLE
            mostrarDetalles(posicionActual)
        }
    }

    //Esta función compara si existe doble panel y determinará si enviarnos a una nueva actividad o mostrar los detalles
    fun mostrarDetalles(index:Int){
        posicionActual = index

        if(hayDoblePanel){
            //Si hay doble panel remplazamos el econtenido del framelayout por nuestro fragment a mostrar
            var fDetalles = activity?.supportFragmentManager?.findFragmentById(R.id.fdetalles) as? ContenidoPeliculas

            if(fDetalles == null || fDetalles.obtenerIndex() != index){
                fDetalles = ContenidoPeliculas().nuevaInstancia(index)

                val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fdetalles,fDetalles)

                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.commit()
            }

        }else{
            //Si no hay doble panel nos manda hacia el activity Detalles
            val intent = Intent(activity,Detalles::class.java)
            intent.putExtra("INDEX",index)
            startActivity(intent)
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_lista_peliculas, container, false)
        return view
    }

    //Función para retornar solo los nombres de las peliculas
    fun obtenerNombrePeliculas(peliculas:ArrayList<Pelicula>):ArrayList<String>{
        val nombres = ArrayList<String>()

        for(pelicula in peliculas){
            nombres.add(pelicula.nombre)
        }
        return nombres
    }

}
