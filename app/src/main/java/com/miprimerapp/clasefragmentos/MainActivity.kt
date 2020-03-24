package com.miprimerapp.clasefragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Fragment1.NombreListener{

    /*Fragments
    *
    * */

    //Creamos una actividad normal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creamos una variable de tipo supportFragmentManager, que nos ayudará para el manejo de los fragmentos que ocupemos
        val fragmentManager = supportFragmentManager

        btnFragment.setOnClickListener {
            //Inicimos el proceso de manipulación del fragmento
            val fragmentTransaction = fragmentManager.beginTransaction()

            //asignamos el fragmento a una variable para usarla despues
            val nuevofragment = Fragment1()
            //Insertamos el fragmento en el contenedor deseado, en este caso es un framelayout  .container
            fragmentTransaction.add(R.id.container,nuevofragment)

            //Lo agregamos al backstack (opcional)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        btnRemFragment.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()

            val nuevofragment = Fragmento2()
            //Lo mismo que con el de arriba, con la diferencia que aqui remplazamos el contenido del framelayout
            fragmentTransaction.replace(R.id.container,nuevofragment)

            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }

    //Interfaz creada para obtener algún valor desde el fragmento
    override fun obtenerNombre(nombre: String) {
        super.obtenerNombre(nombre)
        txtNombre?.text = nombre
    }

}
