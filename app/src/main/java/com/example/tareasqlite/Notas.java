package com.example.tareasqlite;

public class Notas {

    private int Id;
    private String Titulo;
    private String Descripcion;
    private String Imagen;
    public String getTitulo(){
        return Titulo;
    }
    public String getDescripcion(){
        return Descripcion;
    }
    public String getImagen(){
        return Imagen;
    }
    public void setTitulo(String Titulo){
        this.Titulo=Titulo;
    }
    public void setDescripcion(String Descripcion){
        this.Descripcion=Descripcion;
    }
    public void setImagen(String Imagen){
        this.Imagen=Imagen;
    }
    public int getId(){
        return Id;
    }
    public void setId(int Id){
        this.Id=Id;
    }

}
