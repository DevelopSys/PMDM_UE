package com.example.proyectospinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.proyectospinner.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorSencillo: ArrayAdapter<String>
    private lateinit var adaptadorSecilloRecurso: ArrayAdapter<CharSequence>
    private lateinit var listaEquipos: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        asociarDatos()
        acciones()


    }

    private fun acciones() {

        binding.spinnerSencillo.onItemSelectedListener = this
        binding.spinnerSencilloRecurso.onItemSelectedListener = this
    }

    private fun asociarDatos() {
        binding.spinnerSencillo.adapter = adaptadorSencillo;
        binding.spinnerSencilloRecurso.adapter = adaptadorSecilloRecurso;
    }

    private fun instancias() {

        listaEquipos = ArrayList();
        listaEquipos.add("España")
        listaEquipos.add("Brasil")
        listaEquipos.add("Argentina")
        listaEquipos.add("Francia")
        listaEquipos.add("Paises Bajos")
        adaptadorSencillo = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaEquipos)
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adaptadorSencillo.notifyDataSetChanged()

        adaptadorSecilloRecurso = ArrayAdapter.createFromResource(applicationContext,R.array.equipos,android.R.layout.simple_spinner_item)
        adaptadorSecilloRecurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0!!.id){
            R.id.spinner_sencillo->{
                Snackbar.make(p0!!, adaptadorSencillo.getItem(p2).toString(), Snackbar.LENGTH_SHORT).show()
            }
            R.id.spinner_sencillo_recurso->{
                Snackbar.make(p0!!, "Seleccionado recurso ${adaptadorSecilloRecurso.getItem(p2).toString()}", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

}