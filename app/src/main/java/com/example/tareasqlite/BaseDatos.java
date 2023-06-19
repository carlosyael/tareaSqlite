package com.example.tareasqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

 class BaseDatos extends SQLiteOpenHelper {
private static BaseDatos Instancia;
    String crear = "CREATE TABLE Notas(Id INTEGER PRIMARY KEY AUTOINCREMENT, Titulo TEXT, Descripcion TEXT, Imagen TEXT)";

     private BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crear);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Notas");
        db.execSQL(crear);
    }
    public static BaseDatos getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
         if(Instancia==null){
             Instancia= new BaseDatos(context, name, factory,version);
         }
         return Instancia;
    }
}

