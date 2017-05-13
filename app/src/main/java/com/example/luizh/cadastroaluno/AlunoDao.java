package com.example.luizh.cadastroaluno;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    SQLiteDatabase conn = ConexaoBancoDados.getInstance();
    ContentValues c = new ContentValues();

    public void Salvar(Aluno aluno){

        c.put("name",aluno.getName());
        c.put("phone",aluno.getPhone());

        if(aluno.getId() == null || aluno.getId() == 0){
            conn.insert("student",null,c);
        }

        else{
            conn.update("student",c,"id="+aluno.getId(),null);
        }
    }

    public void Excluir(Aluno aluno){

        conn.delete("student","id="+aluno.getId(),null);
    }

    public List<Aluno> Listar() {

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