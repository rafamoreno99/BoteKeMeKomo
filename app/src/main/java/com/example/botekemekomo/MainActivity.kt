package com.example.botekemekomo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.botekemekomo.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonCalcular.setOnClickListener{ calculateTip() }
    }

    //Función para calcular la propina al pulsar el botón
    private fun calculateTip() {
        val cadenaTextFieldCoste = binding.costeServicio.text.toString()
        val costeTotal = cadenaTextFieldCoste.toDouble()
        val tipoSeleccionado = binding.opcionesPropina.checkedRadioButtonId
        val porcentaje = when (tipoSeleccionado) {
            R.id.opcionGenial -> 0.20
            R.id.opcionBien -> 0.18
            else -> 0.15
        }
        var propina = porcentaje * costeTotal
        val redondear = binding.switchRedondear.isChecked
        if (redondear) {
            propina = kotlin.math.ceil(propina)
        }
        val propinaFormateada = NumberFormat.getCurrencyInstance().format(propina)
        binding.resultadoFinal.setText("Montante propina: "+propinaFormateada)

    }
}