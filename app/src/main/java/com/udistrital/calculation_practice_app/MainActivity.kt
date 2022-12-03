package com.udistrital.calculation_practice_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var btn_incrementar: Button
    lateinit var btn_disminuir: Button
    lateinit var tv_counter: TextView
    lateinit var btn_pasar_a_multiplicacion: Button
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter = intent.getIntExtra("counter_from_multiplicacion", 0)

        tv_counter = findViewById(R.id.tv_counter)
        tv_counter.text = counter.toString()

        btn_incrementar = findViewById(R.id.btn_incrementar)
        btn_disminuir = findViewById(R.id.btn_disminuir)
        btn_pasar_a_multiplicacion = findViewById(R.id.btn_pasar_a_multiplicacion)

        btn_incrementar.setOnClickListener {
            counter += 1
            tv_counter.text = counter.toString()
        }

        btn_disminuir.setOnClickListener {
            counter -= 1
            tv_counter.text = counter.toString()
        }

        btn_pasar_a_multiplicacion.setOnClickListener {
            var multiplicacion_activity_intent = Intent(this@MainActivity, Multiplicacion::class.java)
            multiplicacion_activity_intent.putExtra("counter_from_sumar", counter)
            startActivity(multiplicacion_activity_intent)
        }


    }
}