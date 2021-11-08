package com.example.joselitoaugustogironmartinez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  lateinit var resultadoTextView: TextView  //Declaracion de todos los Botones como Botones
  lateinit var ceroBoton: Button
  lateinit var unoBoton: Button
  lateinit var dosBoton: Button
  lateinit var tresBoton: Button
  lateinit var cuatroBoton: Button
  lateinit var cincoBoton: Button
  lateinit var seisBoton: Button
  lateinit var sieteBoton: Button
  lateinit var ochoBoton: Button
  lateinit var nueveBoton: Button
  lateinit var infoBoton: Button
  lateinit var igualBoton: Button
  lateinit var puntoBoton: Button
  lateinit var sumaBoton: Button
  lateinit var restaBoton: Button
  lateinit var multiBoton: Button
  lateinit var divisionBoton: Button
  lateinit var borrarBoton: Button

  private var dato1 = 0.0     //creacion de variables que capturan los datos igresados
  private var dato2 = 0.0
  private var Operacion = 0

  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEvents() //Iniciar evento para cambiar de activity, y permite que se muestre, cada vez que se regresa a esta activity

          resultadoTextView = findViewById(R.id.resultadoTextView)
          unoBoton = findViewById(R.id.unoBoton)
          dosBoton = findViewById(R.id.dosBoton)
          tresBoton = findViewById(R.id.tresBoton)
          cuatroBoton = findViewById(R.id.cuatroBoton)
          cincoBoton = findViewById(R.id.cincoBoton)
          seisBoton = findViewById(R.id.seisBoton)
          sieteBoton = findViewById(R.id.sieteBoton)
          ochoBoton = findViewById(R.id.ochoBoton)
          nueveBoton = findViewById(R.id.nueveBoton)
          infoBoton = findViewById(R.id.infoBoton)
          igualBoton = findViewById(R.id.igualBoton)
          puntoBoton = findViewById(R.id.puntoBoton)
          sumaBoton = findViewById(R.id.sumaBoton)
          restaBoton = findViewById(R.id.restaBoton)
          multiBoton = findViewById(R.id.multiBoton)
          divisionBoton = findViewById(R.id.divisionBoton)
          borrarBoton = findViewById(R.id.borrarBoton)
          ceroBoton = findViewById(R.id.ceroBoton)
          resultadoTextView.text = "0"    //Valor que se le da al TextView para mostrar en pantalla
          Operacion = SinOperacion

          unoBoton.setOnClickListener{numeroPresionado("1")}     //Eventos de Onclik que llaman la funcion numero presionado, que muestra los numeros en la pantalla
          dosBoton.setOnClickListener{numeroPresionado("2")}
          tresBoton.setOnClickListener{numeroPresionado("3")}
          cuatroBoton.setOnClickListener{numeroPresionado("4")}
          cincoBoton.setOnClickListener{numeroPresionado("5")}
          seisBoton.setOnClickListener{numeroPresionado("6")}
          sieteBoton.setOnClickListener{numeroPresionado("7")}
          ochoBoton.setOnClickListener{numeroPresionado("8")}
          nueveBoton.setOnClickListener{numeroPresionado("9")}
          ceroBoton.setOnClickListener{numeroPresionado("0")}
          puntoBoton.setOnClickListener{numeroPresionado(".")}
          borrarBoton.setOnClickListener{borrardatos()}     //Evento Onclick que borrará los fatos y Operaciones del TextView por medio de la funcion borrar datos al momento de presionar el boton borrar
          sumaBoton.setOnClickListener{operacionPresionada(OperacionSuma)}    //Eventos Onclick´s para las operaciones de SUMA, RESTA, MULTIPLICACION y DIVISION, al momento de presionar cada boton
          restaBoton.setOnClickListener{operacionPresionada(OperacionResta)}
          multiBoton.setOnClickListener{operacionPresionada(OperacionMultiplicacion)}
          divisionBoton.setOnClickListener{operacionPresionada(OperacionDivision)}
          igualBoton.setOnClickListener{resultado()}//Evento Onclick para llamar a la funcion Resultado y realice las Operaciones en curso

  }

  private fun numeroPresionado(num: String){      //Funciones que verifica que numero se ha presionado
    if(resultadoTextView.text == "0" && num != ".") { //verificar si fue un numero el que se presiono, de lo contrario no muestra nada en el TxtView
      resultadoTextView.text = "$num"
    } else {
      resultadoTextView.text = "${resultadoTextView.text}$num" //Concatena los numeros cada vez que se presiones un boton y los muestra en el textview
    }

    if(Operacion == SinOperacion){
      dato1 = resultadoTextView.text.toString().toDouble() //convierte los datos del txtView en digitos decimales
    } else {
      dato2 = resultadoTextView.text.toString().toDouble()
    }
  }

  private fun operacionPresionada(Operacion1: Int){   //Función que verificará la operación que se presionó
    this.Operacion = Operacion1
    dato1 = resultadoTextView.text.toString().toDouble()

    resultadoTextView.text = "0"
  }

  private fun resultado(){    //Función que realiza las operaciones, y muestra el resultado en el textView
    val result = when(Operacion) {
      OperacionSuma -> dato1 + dato2
      OperacionResta -> dato1 - dato2
      OperacionMultiplicacion -> dato1 * dato2
      OperacionDivision -> dato1 / dato2
      else -> 0
    }

    dato1 = result as Double

    resultadoTextView.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
  }


  private fun borrardatos(){  //Función que limpiara la pantalla cuando se presione el Boton "C",
    resultadoTextView.text = "0"
    dato1 = 0.0
    dato2 = 0.0
  }

  companion object { // Asigna un valor Constante a los botones de operaciones
    const val OperacionSuma = 1
    const val OperacionResta = 2
    const val OperacionMultiplicacion = 3
    const val OperacionDivision = 4
    const val SinOperacion = 0
  }

  fun initEvents(){   //Función que realizará el cambio de una activity a la Activity Informacion
    val button = findViewById<Button>(R.id.infoBoton)
    button.setOnClickListener{
      val intent = Intent(this, ActivityInformacion::class.java)
      startActivity(intent)
    }
  }

}