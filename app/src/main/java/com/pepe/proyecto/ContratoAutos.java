package com.pepe.proyecto;


import android.os.StrictMode;

public class ContratoAutos  {

    interface ColumnasAuto {
        String ID = "id";
        String FECHA = "modelo";
        String DESCRIPCION = "descripcion";
        String ID_MARCA = "id_marca";
    }

    interface ColumnasMarca{
        String ID = "id";
        String nombre = "nombre";
    }

    interface ColumnasRefaccion {
        String ID = "id";
        String NOMBRE = "nombre";
        String DESCRIPCION = "descripcion";
        String ID_CATEGORIA = "id_categoria";
    }

    interface ColumnasCategoria {
        String ID = "id";
        String SECCION = "seccion";
    }

    interface ColumnasSeguro {
        String ID = "id";
        String nombre = "nombre";
        String descripcion = "descripcion";
        String tipo = "id_tipo";
    }

    interface ColumnasTipo {
        String ID = "id";
        String nombre = "nombre";
    }



}
