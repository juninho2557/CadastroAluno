package com.example.luizh.cadastroaluno;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CadastroAlunoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CadastroAlunoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroAlunoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CadastroAlunoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroAlunoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroAlunoFragment newInstance(String param1, String param2) {
        CadastroAlunoFragment fragment = new CadastroAlunoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.
                inflate(R.layout.fragment_cadastro_aluno, container, false);

        Button btn_salvar = (Button) view.findViewById(R.id.btn_salvar);

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText txt_codigo = (EditText)view.findViewById(R.id.txt_codigo);
                EditText txt_nome = (EditText)view.findViewById(R.id.txt_nome);
                EditText txt_telefone = (EditText)view.findViewById(R.id.txt_telefone);

                Aluno aluno = new Aluno();
                aluno.setCodigo(Long.parseLong(txt_codigo.getText().toString()));
                aluno.setNome(txt_nome.getText().toString());
                aluno.setTelefone(txt_telefone.getText().toString());

                ArrayList array = new ArrayList();

                new AlunoDao().salvar(aluno);

                Toast.makeText(getContext(),aluno.getNome()+" Cadastrado Com Sucesso! =)",
                    Toast.LENGTH_LONG).show();
                txt_codigo.setText(null);
                txt_nome.setText(null);
                txt_telefone.setText(null);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}