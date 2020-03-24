package com.miprimerapp.clasefragmentos.OrientacionEjemplo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miprimerapp.clasefragmentos.R

class OrientacionActivity : AppCompatActivity() {

    //Ejemplo 2
    /*Crearemos una vista en donde podremos ver un uso frecuente de fragments en tabletas, (Usar dobles páneles)
    Debemos crear nuestro layout de forma landscape (Creamos un layout nuevo con el mismo nombre que la actividad, pero setteamos la orientación a landscape)
    Debemos crear 2 fragmentos, uno que será donde mostraremos la lista de peliculas y otro para mostrar los detalles que querramos, en este caso solo es una imagen
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orientacion)
    }
}
