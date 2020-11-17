package com.pepe.proyecto;

import java.io.Serializable;

public class Categoria implements Serializable {
    private String id;
    private String seccion;

    public Categoria(String id, String seccion) {
        this.id = id;
        this.seccion = seccion;
    }
    public Categoria(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id='" + id + '\'' +
                ", seccion='" + seccion + '\'' +
                '}';
    }
}
