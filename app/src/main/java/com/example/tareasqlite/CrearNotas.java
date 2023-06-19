package com.example.tareasqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrearNotas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrearNotas extends Fragment {
    EditText etTitulo,etDescripcion,etImagen;
    Button btnAceptar,btnLimpiar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CrearNotas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrearNotas.
     */
    // TODO: Rename and change types and number of parameters
    public static CrearNotas newInstance(String param1, String param2) {
        CrearNotas fragment = new CrearNotas();
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
        View view = inflater.inflate(R.layout.fragment_crear_notas, container, false);
        btnLimpiar= view.findViewById(R.id.btnLimpiar);
        btnAceptar=view.findViewById(R.id.btnAceptar);
        etTitulo= view.findViewById(R.id.etTitulo);
        etDescripcion= view.findViewById(R.id.etDescripcion);
        etImagen=view.findViewById(R.id.etImagen);
       etTitulo.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           if(etTitulo.getText().toString().equals("Titulo")){
                                               etTitulo.setText("");}
                                       }
                                   });

       etDescripcion.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                if(etDescripcion.getText().toString().equals("Descripcion")){
                                                    etDescripcion.setText("");
                                                }
                                            }
                                        });
               etImagen.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       if(etImagen.getText().toString().equals("Imagen link")){
                           etImagen.setText("");
                       }
                   }
               });
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notas notasobj=new Notas();
                notasobj.setDescripcion(etDescripcion.getText().toString());
                notasobj.setTitulo(etTitulo.getText().toString());
                notasobj.setImagen(etImagen.getText().toString());
                etTitulo.setText("");
                etImagen.setText("");
                etDescripcion.setText("");
                NotasService notasService=new NotasService(getActivity());
                notasService.NotasCreate(notasobj);
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etTitulo.setText("");
                etImagen.setText("");
                etDescripcion.setText("");
            }
        });


        return view;

    }


  /*  public void NotasCreate(Notas notas){
        BaseDatos con= BaseDatos.getInstance(getActivity(),"Usuario",null,3);
        SQLiteDatabase db=con.getWritableDatabase();
        db.execSQL("Insert into Notas(Titulo,Descripcion,Imagen) values('"+notas.Titulo.toString()+"','"+notas.Descripcion.toString()+"','"+notas.Imagen.toString()+"')");

    }*/
}