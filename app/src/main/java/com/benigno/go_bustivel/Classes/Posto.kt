package com.benigno.go_bustivel.Classes

import com.benigno.go_bustivel.SQLite.DBHelper

class Posto {
    var nomePosto: String
    var nomeRzSocial: String
    var municipio: String
    var endereco: String // Futuramente será trocada por objeto que armezene coordenadas de GPS e algumas outras informações
    var combustiveis: ArrayList<Combustivel>

    constructor(nomePosto: String, nomeRzSocial: String, municipio: String, endereco: String, combustiveis: ArrayList<Combustivel> ) {
        this.nomePosto = nomePosto /*Nome fantasia*/
        this.nomeRzSocial = nomeRzSocial
        this.municipio = municipio
        this.endereco = endereco
        this.combustiveis = combustiveis
    }

    fun getInformacao(): String
    {
        var informacao: String

        informacao= "Nome: "+this.nomePosto
        informacao+="Razão social: "+this.nomeRzSocial
        informacao+="Município: "+this.municipio
        informacao+="Bairro: "+this.endereco
        informacao+="Preço Diese: "+this.getPreco(1)
        informacao+="Preço Diesel S10: "+this.getPreco(1)
        informacao+="Preço Etanol: "+this.getPreco(1)
        informacao+="Preço Gasolina: "+this.getPreco(1)
        return informacao
    }

    fun getPreco(tipo: Int):String
    {
        var preco: String = ""
        for( i in 1..4) {
            if(tipo==combustiveis[i].tipo)
            {
                preco = "Minimo R$ " + combustiveis[i].precoMinimo.toString()
                preco += "Medio R$ " + combustiveis[i].precoMedio.toString()
                preco += "\nMaximo R$ " + combustiveis[i].precoMaximo.toString()
                preco += "Usuario R$ " + combustiveis[i].precoUsuario.toString()
            }
        }
        return preco
    }


}