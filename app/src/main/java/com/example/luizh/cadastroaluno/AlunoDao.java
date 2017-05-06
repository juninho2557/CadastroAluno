package com.example.luizh.cadastroaluno;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luizh on 24/03/2017.
 */

class AlunoDao {

    /* TO SAVE ONLY IN MEMORY
    static List<Aluno> alunos = new ArrayList<Aluno>();
    public void salvar(Aluno aluno) { alunos.add(aluno); }
    public List<Aluno> listar() { return alunos; } */

    public void salvar(Aluno aluno){

        SQLiteDatabase conn = ConexaoBancoDados.getInstance();
        ContentValues c = new ContentValues();

        c.put("name",aluno.getName());
        c.put("phone",aluno.getPhone());

        conn.insert("student",null,c);
    }

    public List<Aluno> listar() {

        SQLiteDatabase conn = ConexaoBancoDados.getInstance();
        String[] columns = new String[]{"id", "name", "phone"};
        Cursor c = conn.query("student", columns, null, null, null, null, null);

        List<Aluno> alunos = new ArrayList<Aluno>();

        if (c.moveToFirst()) {

            do {

                Aluno a = new Aluno();
                a.setId(c.getLong(0));
                a.setName(c.getString(1));
                a.setPhone(c.getString(2));

                alunos.add(a);

            } while (c.moveToNext());

        }

        return alunos;
    }
}