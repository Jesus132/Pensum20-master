package com.example.ceisutb18.pensum20

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_recordatorios.*

class Recordatorios : AppCompatActivity(), AdapterView.OnItemSelectedListener  {

    var Semana = arrayOf("1", "2", "3")

    var spinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordatorios)

        val objetoIntent : Intent =intent
        var materia= objetoIntent.getStringExtra("MATERIA")
        Materia.text="  $materia"

        spinner = this.SPsemana
        spinner!!.setOnItemSelectedListener(this)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, Semana)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(aa)
    }

    override fun onItemSelected(p0: AdapterView<*>, p1: View, position: Int, id: Long) {
        var button_seman = findViewById(R.id.button2) as Button
        if(Semana[position] == "1") {
            button_seman.setBackgroundResource(R.drawable.semana1)
        }else if (Semana[position] == "2") {
            button_seman.setBackgroundResource(R.drawable.semana2)
        }else if (Semana[position] == "3") {
            button_seman.setBackgroundResource(R.drawable.semana3)
        }
    }
    override fun onNothingSelected(p0: AdapterView<*>) {

    }
}
