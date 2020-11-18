package com.pepe.proyecto;


import android.os.StrictMode;
import android.provider.BaseColumns;

public class AutosContract {

    public static class AutoEntry implements BaseColumns{
        public static final String TABLE_NAME_AUTO = "auto";
        public static final String ID = "id_auto";
        public static final String FECHA = "modelo";
        public static final String DESCRIPCION = "descripcion";
        public static final String ID_MARCA = "id_marca";
    }

    public static class MarcaEntry implements BaseColumns{
        public static final String TABLE_NAME_AUTO = "marca";
        public static final String ID = "id_marca";
        public static final String FECHA = "nombre";
    }

    public static class RefaccionEntry implements BaseColumns{
        public static final String TABLE_NAME_REFACCION = "refaccion";
        public static final String ID = "id_refaccion";
        public static final String NOMBRE = "nombre";
        public static final String DESCRIPCION = "descripcion";
        public static final String ID_CATEGORIA = "id_categoria";
    }

    public static class CategoriaEntry implements BaseColumns{
        public static final String TABLE_NAME_CATEGORIA = "categoria";
        public static final String ID = "id_categoria";
        public static final String SECCION = "seccion";
    }

    public static class SeguroEntry implements  BaseColumns{
        public static final String TABLE_NAME_SEGURO = "seguro";
        public static final String ID = "id_seguro";
        public static final String NOMBRE = "nombre";
        public static final String DESCRIPCION = "descripcion";
        public static final String ID_TIPO = "id_tipo";
    }

    public static class TipoEntry implements BaseColumns {
        public static final String TABLE_NAME_TIPO = "tipo";
        public static final String ID = "id_tipo";
        public static final String NOMBRE = "nombre";
    }
}
