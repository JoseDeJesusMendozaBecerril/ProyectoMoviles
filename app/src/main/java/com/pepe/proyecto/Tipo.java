package com.pepe.proyecto;

import java.io.Serializable;

public class Tipo implements Serializable {

    private String id;
    private String nombre;

    public Tipo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Tipo(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
