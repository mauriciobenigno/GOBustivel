package com.benigno.go_bustivel.TelasTeste

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.benigno.go_bustivel.Classes.Combustivel
import com.benigno.go_bustivel.Classes.Posto
import com.benigno.go_bustivel.R
import com.benigno.go_bustivel.SQLite.DBHelper
import kotlinx.android.synthetic.main.activity_tela_cadastro_posto.*

class TelaCadastroPosto : AppCompatActivity() {

    internal lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_posto)

        btCadastrarPosto.setOnClickListener {
            // Validações
            var nomeB: Boolean = TemTexto(campoNome.text.toString())
            var rzSocialB: Boolean = TemTexto(campoRzSocial.text.toString())
            var cidadeB: Boolean = TemTexto(campoCidade.text.toString())
            var bairroB: Boolean = TemTexto(campoBairro.text.toString())
            var campoMinB: Boolean = TemTexto(campoDVmin.text.toString())
            var campoMedB: Boolean = TemTexto(campoDVmed.text.toString())
            var campoMaxB: Boolean = TemTexto(campoDVmax.text.toString())
            var campoUsrB: Boolean = TemTexto(campoDVmax.text.toString())
            // Se todas retornarem True, então todos os campos de texto foram preenchidos, caso contrário, um alerta avisa que não
            var builder = AlertDialog.Builder(this@TelaCadastroPosto)
            builder.setTitle("Faltam informações")

            var mensagem: String = "Informe:\n"
            var continuarGrava: Boolean = true;
            if (!nomeB) {
                mensagem += " O nome do posto.\n"
                continuarGrava = false
            }
            if (!rzSocialB){
                mensagem+=" A razão social do posto.\n"
                continuarGrava=false
            }
            if (!cidadeB) {
                mensagem += " A cidade onde o posto fica.\n"
                continuarGrava=false
            }
            if (!bairroB) {
                mensagem += " O bairro onde o posto fica.\n"
                continuarGrava = false
            }
            if (!campoMinB) {
                mensagem += " O valor minimo registrado.\n"
                continuarGrava = false
            }
            if (!campoMedB) {
                mensagem += " O valor medio registrado.\n"
                continuarGrava = false
            }
            if (!campoMaxB){
                mensagem+=" O valor maximo registrado.\n"
                continuarGrava=false
            }
            if (!campoUsrB) {
                mensagem += " O valor de usuário registrado.\n"
                continuarGrava=false
            }
            if (!continuarGrava) {
                builder.setMessage(mensagem)
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
            else{
                // Criando os objetos combustível
                var combustiveis: ArrayList<Combustivel>
                combustiveis = ArrayList<Combustivel>()
                var combustivel = Combustivel(1,
                    campoDVmin.text.toString().toFloat(), campoDVmed.text.toString().toFloat(),
                    campoDVmax.text.toString().toFloat(), campoDSVusr.text.toString().toFloat())
                combustiveis.add(combustivel)

                combustivel = Combustivel(2,
                    campoDVmin.text.toString().toFloat(), campoDVmed.text.toString().toFloat(),
                    campoDVmax.text.toString().toFloat(), campoDSVusr.text.toString().toFloat())
                combustiveis.add(combustivel)

                combustivel = Combustivel(3,
                    campoDVmin.text.toString().toFloat(), campoDVmed.text.toString().toFloat(),
                    campoDVmax.text.toString().toFloat(), campoDSVusr.text.toString().toFloat())
                combustiveis.add(combustivel)

                combustivel = Combustivel(4,
                    campoDVmin.text.toString().toFloat(), campoDVmed.text.toString().toFloat(),
                    campoDVmax.text.toString().toFloat(), campoDSVusr.text.toString().toFloat())
                combustiveis.add(combustivel)

                // Criando o objeto Posto
                val posto = Posto(
                    campoNome.text.toString(),
                    campoRzSocial.text.toString(),
                    campoCidade.text.toString(),
                    campoBairro.text.toString(),
                    combustiveis)

                // Adicionando ao banco de dados
                db.addPosto(posto)
            }
        }
    }

    fun TemTexto(texto: String): Boolean
    {
        return texto.length>0
    }

}
