package com.example.tareasqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NotasAdapterEditDelete extends ArrayAdapter<Notas> {
    private int layoutResource;

    public NotasAdapterEditDelete(Context context, int resource, ArrayList<Notas> objects) {
        super(context, resource, objects);
        layoutResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layoutResource, parent, false);
        }

        Notas notas = getItem(position);

        // Obtener referencias a los elementos de tu diseño XML
        EditText etImagen = convertView.findViewById(R.id.etEDImagen);
        EditText etTitulo= convertView.findViewById(R.id.etEDTitulo);
        EditText etDescripcion = convertView.findViewById(R.id.etEDDescripcion);
        TextView tvId= convertView.findViewById(R.id.tvEDId);

        // Configurar los valores en los elementos de la vista
        etTitulo.setText(notas.getTitulo());
        etImagen.setText(notas.getImagen());
        tvId.setText(String.valueOf(notas.getId()));
        etDescripcion.setText(notas.getDescripcion());

        return convertView;
    }
}


