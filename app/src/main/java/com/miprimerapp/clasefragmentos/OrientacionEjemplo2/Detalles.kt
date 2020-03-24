package com.miprimerapp.clasefragmentos.OrientacionEjemplo2

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miprimerapp.clasefragmentos.R

class Detalles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        //Si determina que estamos en modo horiontal termina la actividad
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish()
            return
        }

        //Si no tenemos nada guardado pasamos argumentos a nuestro fragmento detalles (Similar a pasar extras por intents a activities)
        if(savedInstanceState == null){
            val fDetalles = ContenidoPeliculas()
            fDetalles.arguments = intent.extras
            supportFragmentManager.beginTransaction().add(R.id.container,fDetalles).commit()
        }


       /* val index = intent.getIntExtra("INDEX",0)
        imgFoto.setImageResource(ListaPeliculas.peliculas?.get(index)?.imagen!!)
    */
    }

}
