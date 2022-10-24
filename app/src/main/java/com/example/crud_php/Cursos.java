package com.example.crud_php;

public class Cursos {
    String id,nombreCurso,urlCurso,categoria,descripcion;

    public Cursos() {
    }
    public Cursos(String id, String nombreCurso, String urlCurso, String categoria,String descripcion) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.urlCurso = urlCurso;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombreCurso;
    }

    public void setNombre(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getUrlCurso() {
        return urlCurso;
    }

    public void setUrlCurso(String urlCurso) {
        this.urlCurso = urlCurso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
