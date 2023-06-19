package com.example.tareasqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NotasAdapterShow extends ArrayAdapter<Notas> {
    private int layoutResource;

    public NotasAdapterShow(Context context, int resource, ArrayList<Notas> objects) {
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
        ImageView ivImagen = convertView.findViewById(R.id.ivImagen);
        TextView tvTitulo= convertView.findViewById(R.id.tvTitulo);
        TextView tvDescripcion = convertView.findViewById(R.id.tvDescripcion);

        // Configurar los valores en los elementos de la vista
        String url = notas.getImagen(); //El link de la imagen que quieres mostrar
        Glide.with(getContext()).load(url).into(ivImagen); //Carga la imagen en el ImageView
        tvTitulo.setText(notas.getTitulo());
        tvDescripcion.setText(notas.getDescripcion());

        return convertView;
    }
}
