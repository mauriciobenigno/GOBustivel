package com.benigno.go_bustivel.SQLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.benigno.go_bustivel.Classes.Combustivel
import com.benigno.go_bustivel.Classes.Posto

class DBHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "combPostos.db"
        // Tabela
        private val NOME_TABELA = "Posto"
        // Colunas
        private val ID_POSTO = "id"
        private val RAZAOSOCIAL_POSTO = "RazaoSocial"
        private val NOMEFANTASIA_POSTO = "NomeFantasia"
        private val MUNICIPIO_POSTO = "Cidade"
        private val BAIRRO_POSTO = "Bairro"
        // Tipo 1 - Diesel comum
        private val VLRMINTP1_POSTO = "VlrMinTP1"
        private val VLRMEDTP1_POSTO = "VlrMedTP1"
        private val VLRMAXTP1_POSTO = "VlrMaxTP1"
        private val VLRUSRTP1_POSTO = "VlrUsrTP1"
        // Tipo - 2 Diese S10
        private val VLRMINTP2_POSTO = "VlrMinTP2"
        private val VLRMEDTP2_POSTO = "VlrMedTP2"
        private val VLRMAXTP2_POSTO = "VlrMaxTP2"
        private val VLRUSRTP2_POSTO = "VlrUsrTP2"
        // Tipo - 3 Etanol
        private val VLRMINTP3_POSTO = "VlrMinTP3"
        private val VLRMEDTP3_POSTO = "VlrMedTP3"
        private val VLRMAXTP3_POSTO = "VlrMaxTP3"
        private val VLRUSRTP3_POSTO = "VlrUsrTP3"
        // Tipo - 4 Gasolina
        private val VLRMINTP4_POSTO = "VlrMinTP4"
        private val VLRMEDTP4_POSTO = "VlrMedTP4"
        private val VLRMAXTP4_POSTO = "VlrMaxTP4"
        private val VLRUSRTP4_POSTO = "VlrUsrTP4"
    }

    override fun onCreate(db: SQLiteDatabase?)
    {
        val CREATE_TABLE_QUERY: String = ("CREATE TABLE $NOME_TABELA ($ID_POSTO INTEGER PRIMARY KEY AUTOINCREMENT, $RAZAOSOCIAL_POSTO +  TEXT, $NOMEFANTASIA_POSTO  TEXT, $MUNICIPIO_POSTO TEXT, $BAIRRO_POSTO TEXT, $VLRMINTP1_POSTO REAL, $VLRMEDTP1_POSTO REAL, $VLRMAXTP1_POSTO REAL, $VLRUSRTP1_POSTO REAL, $VLRMINTP2_POSTO REAL, $VLRMEDTP2_POSTO REAL, $VLRMAXTP2_POSTO REAL, $VLRUSRTP2_POSTO REAL, $VLRMINTP3_POSTO REAL, $VLRMEDTP3_POSTO REAL, $VLRMAXTP3_POSTO REAL, $VLRUSRTP3_POSTO REAL, $VLRMINTP4_POSTO REAL, $VLRMEDTP4_POSTO REAL, $VLRMAXTP4_POSTO REAL, $VLRUSRTP4_POSTO REAL)")
        db!!.execSQL(CREATE_TABLE_QUERY);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int){
        db!!.execSQL("DROP TABLE IF EXISTS $NOME_TABELA")
        onCreate(db!!)
    }

    //CRUD
    val todosPostos:List<Posto>
        get(){
            val listaPostos = ArrayList<Posto>()
            val selectQuery = "SELECT * FROM $NOME_TABELA"
            val db:SQLiteDatabase = this.writableDatabase
            val cursor: Cursor = db.rawQuery(selectQuery, null)
            if(cursor.moveToFirst())
            {
                do {
                    val nomePosto: String = cursor.getString(cursor.getColumnIndex(NOMEFANTASIA_POSTO))
                    val nomeRzSocial: String = cursor.getString(cursor.getColumnIndex(RAZAOSOCIAL_POSTO))
                    val municipio: String = cursor.getString(cursor.getColumnIndex(MUNICIPIO_POSTO))
                    val endereco: String =cursor.getString(cursor.getColumnIndex(BAIRRO_POSTO))

                    /* Lista de combustíveis*/
                    // Falta criar tratamento de excessão para casos em que não há valores para os combustíveis
                    val combustiveis: ArrayList<Combustivel>
                    combustiveis = ArrayList<Combustivel>()
                    // Tipo 1
                    val combustivelTipo1 = Combustivel(1,
                            cursor.getFloat(cursor.getColumnIndex(VLRMINTP1_POSTO)),
                            cursor.getFloat(cursor.getColumnIndex(VLRMEDTP1_POSTO)),
                            cursor.getFloat(cursor.getColumnIndex(VLRMAXTP1_POSTO)),
                            cursor.getFloat(cursor.getColumnIndex(VLRUSRTP1_POSTO)))
                    combustiveis.add(combustivelTipo1)

                    // Tipo 2
                    val combustivelTipo2 = Combustivel(2,
                        cursor.getFloat(cursor.getColumnIndex(VLRMINTP2_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRMEDTP2_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRMAXTP2_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRUSRTP2_POSTO)))
                    combustiveis.add(combustivelTipo2)
                    // Tipo 3
                    val combustivelTipo3 = Combustivel(3,
                        cursor.getFloat(cursor.getColumnIndex(VLRMINTP3_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRMEDTP3_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRMAXTP3_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRUSRTP3_POSTO)))
                    combustiveis.add(combustivelTipo3)
                    // Tipo 4
                    val combustivelTipo4 = Combustivel(4,
                        cursor.getFloat(cursor.getColumnIndex(VLRMINTP4_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRMEDTP4_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRMAXTP4_POSTO)),
                        cursor.getFloat(cursor.getColumnIndex(VLRUSRTP4_POSTO)))
                    combustiveis.add(combustivelTipo4)

                    val posto = Posto(nomePosto, nomeRzSocial,municipio, endereco, combustiveis)
                    listaPostos.add(posto)
                } while(cursor.moveToNext())
            }
            return listaPostos
        }

    fun addPosto(posto: Posto)
    {
        val db:SQLiteDatabase = this.writableDatabase
        val valores = ContentValues()
        // Nome e endereço
        valores.put(RAZAOSOCIAL_POSTO, posto.nomeRzSocial)
        valores.put(NOMEFANTASIA_POSTO, posto.nomePosto)
        valores.put(MUNICIPIO_POSTO, posto.municipio)
        valores.put(BAIRRO_POSTO, posto.endereco)
        // Percorre a lista de categorias de combusível
        for( i in 1..4)
        {
            when(i)
            {
                1 -> {
                    // Valor Diesel
                    valores.put(VLRMINTP1_POSTO, posto.combustiveis[i].precoMinimo)
                    valores.put(VLRMEDTP1_POSTO, posto.combustiveis[i].precoMedio)
                    valores.put(VLRMAXTP1_POSTO, posto.combustiveis[i].precoMaximo)
                    valores.put(VLRUSRTP1_POSTO, posto.combustiveis[i].precoMaximo)
                }
                2 -> {
                    // Valor Diesel S10
                    valores.put(VLRMINTP2_POSTO, posto.combustiveis[i].precoMinimo)
                    valores.put(VLRMEDTP2_POSTO, posto.combustiveis[i].precoMedio)
                    valores.put(VLRMAXTP2_POSTO, posto.combustiveis[i].precoMaximo)
                    valores.put(VLRUSRTP2_POSTO, posto.combustiveis[i].precoMaximo)
                }
                3 -> {
                    // Valor Etanol Comum
                    valores.put(VLRMINTP3_POSTO, posto.combustiveis[i].precoMinimo)
                    valores.put(VLRMEDTP3_POSTO, posto.combustiveis[i].precoMedio)
                    valores.put(VLRMAXTP3_POSTO, posto.combustiveis[i].precoMaximo)
                    valores.put(VLRUSRTP3_POSTO, posto.combustiveis[i].precoMaximo)
                }
                4 -> {
                    // Valor Gasolina Comum
                    valores.put(VLRMINTP4_POSTO, posto.combustiveis[i].precoMinimo)
                    valores.put(VLRMEDTP4_POSTO, posto.combustiveis[i].precoMedio)
                    valores.put(VLRMAXTP4_POSTO, posto.combustiveis[i].precoMaximo)
                    valores.put(VLRUSRTP4_POSTO, posto.combustiveis[i].precoMaximo)
                }
            }
        }
        // Insere dados no banco de dados e fecha conexão
        db.insert(NOME_TABELA, null, valores)
        db.close()

    }

}