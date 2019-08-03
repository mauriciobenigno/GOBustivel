package com.benigno.go_bustivel.Classes

class Combustivel {
    /* A variavel 'tipo' inteiro vai indicar o tipo de combustível ofertado (Ex: 1 - Diesel, 2 - Diesel S10, 3 - Etanol, etc)
    * As variaveis 'precoXXXX' vão indicar os valores minimo, medio e maximo, informados pela Sefaz em Goiás*/

    val tipo: Int
    val precoMinimo: Float
    val precoMedio: Float
    val precoMaximo: Float
    val precoUsuario: Float

    constructor(tipo: Int, precoMinimo: Float, precoMedio: Float, precoMaximo: Float,precoUsuario: Float)
    {
        this.tipo=tipo
        this.precoMinimo=precoMinimo
        this.precoMedio=precoMedio
        this.precoMaximo=precoMaximo
        this.precoUsuario = precoUsuario
    }

}