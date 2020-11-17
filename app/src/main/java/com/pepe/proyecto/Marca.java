package com.pepe.proyecto;

import java.io.Serializable;

public class Marca implements Serializable {
    private String id;
    private String nombre;


    public Marca(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Marca(){

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
        return "Marca{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
