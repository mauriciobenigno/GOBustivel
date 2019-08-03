package com.benigno.go_bustivel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.benigno.go_bustivel.TelasTeste.TelaCadastroPosto
import com.benigno.go_bustivel.TelasTeste.TelaConsultaPosto

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BOTÕES
        var btCadastro = findViewById<Button>(R.id.btCadastro)
        var btExcluir = findViewById<Button>(R.id.btExcluir)
        var btConsultar = findViewById<Button>(R.id.btConsulta)


        btCadastro.setOnClickListener {
            val intentTelaCadastroPosto = Intent(this, TelaCadastroPosto::class.java)
            startActivity(intentTelaCadastroPosto)
        }

        btExcluir.setOnClickListener {
            val intentTelaExcluirPosto = Intent(this, TelaConsultaPosto::class.java)
            startActivity(intentTelaExcluirPosto)
        }

        btConsultar.setOnClickListener {
            val intentTelaConsultaPosto = Intent(this, TelaConsultaPosto::class.java)
            startActivity(intentTelaConsultaPosto)
        }
    }





}
