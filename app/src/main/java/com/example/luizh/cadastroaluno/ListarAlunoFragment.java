package com.example.luizh.cadastroaluno;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.service.carrier.CarrierMessagingService;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URI;
import java.util.zip.Inflater;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListarAlunoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListarAlunoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListarAlunoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ListarAlunoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListarAlunoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListarAlunoFragment newInstance(String param1, String param2) {
        ListarAlunoFragment fragment = new ListarAlunoFragment();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listar_aluno, container, false);
        final ListView listView = (ListView)view.findViewById(R.id.lista_aluno);
        final ArrayAdapter<Aluno> arrayAdapterAlunos = new ArrayAdapter<Aluno>(getContext(),android.R.layout.simple_list_item_1);
        arrayAdapterAlunos.addAll(new AlunoDao().listar());
        listView.setAdapter(arrayAdapterAlunos);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Aluno a = (Aluno)parent.getItemAtPosition(position);
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+a.getTelefone())));
            }
        });

        return view;
    }

    /*

    -- TESTES --

    //Toast.makeText(getContext()," Registro Pego: "+a.getTelefone(), Toast.LENGTH_LONG).show();
    //String cursor = (listView.getItemAtPosition(position).toString());
    //String S = view.getContext().toString();
    //String phone = view.getContext().toString();
    //parent.getAdapter().getItem(position);
    //String kkk = (listView.getOnItemClickListener().toString());
    //String text = listView.getAdapter(position).toString().trim();
    //String hehe = listView.getItemAtPosition(position);
    //String s = values.get(position).getCoun
    //String phone = cursor.g
    //String str = cursor.get
    //Cursor c = (Cursor) listView.getItemAtPosition(position);
    //String aa = c.getString(c.getColumnIndex("Phone"));
    //Cursor currentCur = listView.getItemAtPosition(position);
    //String name = currentCur.getString(1);

    //Intent 1 - Ligação
    //Intent it = new Intent(Intent.ACTION_DIAL);
    //String p = "tel:" + "36434680";
    //it.setData(Uri.parse(p));
    //startActivity(it);

    //Intent 2 - Skype
    //Uri uri = Uri.parse("996135114");
    //Intent it = new Intent(Intent.ACTION_CALL,uri);
    //startActivity(it);

    //Pra Internet
    //Uri uri = Uri.parse("http://youtube.com");
    //Intent it = new Intent(Intent.ACTION_VIEW,uri);
    //startActivity(it);

    //Toast.makeText(getContext(),aluno.getNome()+" Cadastrado Com Sucesso! =)",
    //Toast.LENGTH_LONG).show();

    //String val =(String) parent.getItemAtPosition(position);
    //System.out.println("Value is "+val);

    */

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
     * fragment tcmo allow an interaction in this fragment to be communicated
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