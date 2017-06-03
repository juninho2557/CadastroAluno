package com.example.luizh.cadastroaluno;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.TextViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luizh on 19/05/2017.
 */

public class AdapterPersonalizado extends BaseAdapter {

    private final List<Aluno> alunos;
    private final Fragment frag;

    public AdapterPersonalizado(List<Aluno> alunos, Fragment frag) {
        this.alunos = alunos;
        this.frag = frag;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = frag.getLayoutInflater(new Bundle()).inflate(R.layout.lista_personalizada, parent, false);
        Aluno aluno = alunos.get(position);

        //Pegando as Referências das Views
        TextView nome = (TextView)view.findViewById(R.id.lista_curso_personalizada_nome);
        TextView telefone = (TextView)view.findViewById(R.id.lista_curso_personalizada_telefone);
        ImageView imagem = (ImageView)view.findViewById(R.id.lista_curso_personalizada_imagem);

        //Populando Views
        nome.setText(aluno.getName());
        telefone.setText(aluno.getPhone());
        imagem.setImageResource(R.drawable.luiz);

        return view;
    }
}
