package com.benigno.go_bustivel.Classes

class Posto {
    val nomePosto: String
    val endereco: String // Futuramente será trocada por objeto que armezene coordenadas de GPS e algumas outras informações
    val combustiveis = ArrayList<Combustivel>

    constructor(nomePosto: String, endereco: String, combustiveis: ArrayList<Combustivel> ) {
        this.nomePosto = nomePosto
        this.endereco = endereco
        this.combustiveis = combustiveis
    }
}