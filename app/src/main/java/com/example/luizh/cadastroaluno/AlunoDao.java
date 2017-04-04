package com.example.luizh.cadastroaluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luizh on 24/03/2017.
 */

class AlunoDao {

    static List<Aluno> alunos = new ArrayList<Aluno>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listar() {
        return alunos;
    }
}
