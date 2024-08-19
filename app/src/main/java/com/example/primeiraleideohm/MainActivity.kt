package com.example.ohmslawcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.primeiraleideohm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etVoltage = findViewById<EditText>(R.id.et_voltage)
        val etCurrent = findViewById<EditText>(R.id.et_current)
        val etResistance = findViewById<EditText>(R.id.et_resistance)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        btnCalculate.setOnClickListener {
            val voltageText = etVoltage.text.toString()
            val currentText = etCurrent.text.toString()
            val resistanceText = etResistance.text.toString()

            if (voltageText.isNotEmpty() && currentText.isNotEmpty()) {
                // Calcula resistência: R = V / I
                val voltage = voltageText.toDouble()
                val current = currentText.toDouble()
                val resistance = voltage / current
                tvResult.text = "Resistência (R): $resistance Ω"
            } else if (voltageText.isNotEmpty() && resistanceText.isNotEmpty()) {
                // Calcula corrente: I = V / R
                val voltage = voltageText.toDouble()
                val resistance = resistanceText.toDouble()
                val current = voltage / resistance
                tvResult.text = "Corrente (I): $current A"
            } else if (currentText.isNotEmpty() && resistanceText.isNotEmpty()) {
                // Calcula tensão: V = R * I
                val current = currentText.toDouble()
                val resistance = resistanceText.toDouble()
                val voltage = current * resistance
                tvResult.text = "Tensão (V): $voltage V"
            } else {
                Toast.makeText(this, "Por favor, preencha dois valores.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}