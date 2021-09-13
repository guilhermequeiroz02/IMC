package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Bt_Calculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        val id = v.id
        if (id == R.id.Bt_Calculate) {
            Tv_Result.text =
                table(nome = Et_Name.text.toString(), calculo = calculate())
        }

    }

    private fun calculate(): Float {

        val height = Et_Height.text.toString().toFloat()
        val weight = Et_Weight.text.toString().toFloat()

        return weight / (height * height)
    }

    private fun table(nome: String, calculo: Float): String {

        if (calculo in 18.5..24.9)
            return "$nome seu imc é $calculo e está normal."
        else if
                     (calculo in 25.0..29.9) {
            return ("$nome seu imc é $calculo você está com sobrepeso.")

        } else if
                       (calculo in 30.0..39.9) {
            return ("$nome seu imc é $calculo você está com obesidade.")

        } else if (calculo > 39.9) {
            return ("$nome seu imc é $calculo; e você está com obesidade GRAVE")

        } else {
            return "Valor inválido"
        }
    }
}