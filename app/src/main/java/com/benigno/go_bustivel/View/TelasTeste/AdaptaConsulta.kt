package com.benigno.go_bustivel.TelasTeste

import android.app.Activity
import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.benigno.go_bustivel.Classes.Posto
import com.benigno.go_bustivel.R
import kotlinx.android.synthetic.main.lista_postos_layout.view.*

class AdaptaConsulta (internal var activity: Activity, internal  var listaPostos:List<Posto>):BaseAdapter()
{
    internal var inflater:LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = inflater.inflate(R.layout.lista_postos_layout, null)

        rowView.txt_idnome_posto.text = listaPostos[position].nomePosto
        var preco: String = "Gasolina R$"
        preco+=listaPostos[position].combustiveis[1].precoMedio.toString()
        rowView.txt_preco_posto.text=preco

        // Mostrar informações completas
        rowView.setOnClickListener {
            // Se todas retornarem True, então todos os campos de texto foram preenchidos, caso contrário, um alerta avisa que não
            var builder = AlertDialog.Builder(activity)
            builder.setTitle("Faltam informações")
            var mensagem: String = listaPostos[position].getInformacao()
            builder.setMessage(mensagem)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return listaPostos[position]
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return listaPostos.size
    }
}