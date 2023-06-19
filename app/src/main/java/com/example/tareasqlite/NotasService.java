package com.example.tareasqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotasService {

    private BaseDatos con;
    private SQLiteDatabase db;
    public NotasService(Context context){
        con=BaseDatos.getInstance(context,"Usuario",null,3);
        db=con.getWritableDatabase();
    }
    public void NotasUpdate(Notas notas){
        db.execSQL("Update Notas set Titulo= '"+notas.getTitulo()+"', Descripcion='"+notas.getDescripcion()+"', Imagen='"+notas.getImagen()+"' where Id="+notas.getId());

    }
    public void NotasDelete(Notas notas){
    db.execSQL("Delete from Notas where Id="+notas.getId());
    }
    public void NotasCreate(Notas notas){
    db.execSQL("Insert into Notas(Titulo,Descripcion,Imagen) values('"+notas.getTitulo().toString()+"','"+notas.getDescripcion().toString()+"','"+notas.getImagen().toString()+"')");

    }
    public ArrayList<Notas> NotasVer(){
    ArrayList<Notas>lista= new ArrayList<>();
        Cursor c=db.rawQuery("select * from Notas",null);
        if(c.moveToFirst()) {
            do {
                Notas notasobj = new Notas();
                notasobj.setId(c.getInt(0));
                notasobj.setTitulo(c.getString(1));
                notasobj.setDescripcion(c.getString(2));
                notasobj.setImagen(c.getString(3));
                lista.add(notasobj);
            } while (c.moveToNext());
        }
        c.close();
        return lista;
    }
}


