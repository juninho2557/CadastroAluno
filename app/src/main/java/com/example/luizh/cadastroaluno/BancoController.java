package com.example.luizh.cadastroaluno;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by luizh on 07/04/2017.
 */

public class BancoController {

    private SQLiteDatabase db;
    private ConexaoBancoDados banco;

    /*public BancoController(Context context){
        banco = new ConexaoBancoDados(context);
    }

    public String Insert(String name, String phone){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(ConexaoBancoDados.NAME, name);
        valores.put(ConexaoBancoDados.PHONE, phone);

        resultado = db.insert(ConexaoBancoDados.STUDENT, null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao Inserir Registro";

        else
            return "Registro Inserido Com Sucesso";
    }*/

}