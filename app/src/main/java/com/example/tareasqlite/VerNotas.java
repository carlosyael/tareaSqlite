package com.example.tareasqlite;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VerNotas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VerNotas extends Fragment {
    private ListView listView;
    private NotasAdapterShow notasAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btnActualizar;

    public VerNotas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VerNotas.
     */
    // TODO: Rename and change types and number of parameters
    public static VerNotas newInstance(String param1, String param2) {
        VerNotas fragment = new VerNotas();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ver_notas, container, false);
        listView = view.findViewById(R.id.lvVerNotas); // Obtén referencia al ListView desde la vista inflada
        NotasService notasService=new NotasService(getContext());
        btnActualizar= view.findViewById(R.id.btnActualizar);


        if(notasService.NotasVer()!=null){
            notasAdapter = new NotasAdapterShow(getActivity(), R.layout.item_mostrar_notas, notasService.NotasVer());
            listView.setAdapter(notasAdapter);

        }
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notasService.NotasVer()!=null){
                    notasAdapter = new NotasAdapterShow(getActivity(), R.layout.item_mostrar_notas, notasService.NotasVer());
                    listView.setAdapter(notasAdapter);

                }

            }
        });


        return view;
    }


}