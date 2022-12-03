package com.udistrital.calculation_practice_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Multiplicacion : AppCompatActivity() {

    var counter: Int = 0
    lateinit var tv_counter_mult: TextView
    lateinit var valor_multiplicacion: EditText
    lateinit var btn_pasar_a_sumar: Button
    lateinit var btn_multiplicar: Button
    lateinit var btn_dividir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplicacion)
        counter = intent.getIntExtra("counter_from_sumar", 0)
        valor_multiplicacion = findViewById(R.id.valorMultiplicacion)
        tv_counter_mult = findViewById(R.id.tv_counter_mult)
        tv_counter_mult.text = counter.toString()
        btn_pasar_a_sumar = findViewById(R.id.btn_pasar_a_sumar)
        btn_multiplicar = findViewById(R.id.btn_multiplicar)
        btn_dividir = findViewById(R.id.btn_dividir)

        btn_pasar_a_sumar.setOnClickListener {
            var mainActivityIntent = Intent(this@Multiplicacion, MainActivity::class.java)
            mainActivityIntent.putExtra("counter_from_multiplicacion", counter)
            startActivity(mainActivityIntent)
        }

        btn_multiplicar.setOnClickListener {
            var num: Int? = valor_multiplicacion.text.toString().toIntOrNull()
            num?.let{
                counter *= it
                tv_counter_mult.text = counter.toString()
            }
        }

        btn_dividir.setOnClickListener {
            var num: Int? = valor_multiplicacion.text.toString().toIntOrNull()
            num?.let{
                counter /= it
                tv_counter_mult.text = counter.toString()
            }
        }

    }
}