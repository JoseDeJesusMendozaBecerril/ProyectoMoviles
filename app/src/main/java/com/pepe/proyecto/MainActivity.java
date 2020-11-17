package com.pepe.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    Button btnviewInsertar;
    Button btnviewVisualizar;
    Button btnviewEliminar;
    Button btnviewActualizar;

    String archivoXMLCategorias;// = "https://blogpersonalpepe.000webhostapp.com/categorias.xml";
    String archivoXMLMarcas;// = "https://blogpersonalpepe.000webhostapp.com/marcas.xml";
    String archivoXMLTipos;// = "https://blogpersonalpepe.000webhostapp.com/tipos.xml";


    ArrayList<Categoria> categorias;
    ArrayList<Marca> marcas;
    ArrayList<Tipo> tipos;

    String prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        addMethods();

        //PRUEBA
        //downloadCatalogos();
        //System.out.println("Categorias");
        //imprimeCategorias();
        //System.out.println("Marcas");
        //imprimeMarcas();
        //System.out.println("Tipos");
        //imprimeTipos();
    }
    public void initComponents(){
        this.btnviewInsertar = (Button) findViewById(R.id.btnViewInserta);
        this.btnviewVisualizar = (Button) findViewById(R.id.btnViewVisualizar);
        this.btnviewEliminar = (Button) findViewById(R.id.btnViewEliminar);
        this.btnviewActualizar = (Button) findViewById(R.id.btnViewActualizar);
    }
    public void addMethods(){
        this.btnviewInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(v,1);
            }
        });

        this.btnviewVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(v,2);
            }
        });

        this.btnviewEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(v,3);
            }
        });

        this.btnviewActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(v,4);
            }
        });
    }
    public void changeActivity(View v ,  int op){
        Intent intent = null;
        switch (op){
            case 1:
                intent = new Intent(v.getContext(), InsertaActivity.class);
                break;
            case 2:
                intent = new Intent(v.getContext(), VisualizaActivity.class);
                break;
            case 3:
                intent = new Intent(v.getContext(), EliminaActivity.class);
                break;
            case 4:
                intent = new Intent(v.getContext(), ActualizaActivity.class);
                break;

        }
        startActivity(intent);
    }


    public void downloadCatalogos(){

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            Toast.makeText(getApplicationContext(),"Conexion Establecida", Toast.LENGTH_SHORT).show();
            categorias = leerCategorias();
            marcas = leerMarcas();
            tipos = leerTipos();
        }
    }

    //----------------------------------------------------TRATAMIENTO DE XML -----------------------------
    //LISTO
    public ArrayList<Categoria> leerCategorias(){
        HttpURLConnection conn = null;
        ArrayList<Categoria> categorias = null;

        try{
            URL url = new URL(archivoXMLCategorias);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();

            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                Document doc = parseXML(conn.getInputStream()); //checar importacion
                categorias = parseCategoria(doc.getDocumentElement());
            }
            else if(responseCode == HttpURLConnection.HTTP_CONFLICT){
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(conn != null){
                conn.disconnect();
            }
        }
        return categorias;
    }
    private ArrayList<Categoria> parseCategoria(Element raiz){
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        NodeList items = raiz.getElementsByTagName("categoria");
        for(int i=0; i < items.getLength(); i++){
            Node nodoCategoria = items.item(i);
            Categoria categoria = new Categoria();
            //Recorremos todos los hijos que tenga el nodo libro

            for(int j = 0; j < nodoCategoria.getChildNodes().getLength(); j++){
                Node nodoActual = nodoCategoria.getChildNodes().item(j);
                if(nodoActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodoActual.getNodeName().equalsIgnoreCase("id")){
                        categoria.setId(nodoActual.getChildNodes().item(0).getNodeValue());
                    }
                    else if(nodoActual.getNodeName().equalsIgnoreCase("nombre")){
                        categoria.setSeccion(nodoActual.getChildNodes().item(0).getNodeValue());
                    }
                }
            }
            categorias.add(categoria);
        }
        return categorias;
    }

    //LISTO
    public ArrayList<Marca> leerMarcas(){
        HttpURLConnection conn = null;
        ArrayList<Marca> marcas = null;

        try{
            URL url = new URL(archivoXMLMarcas);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();

            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                Document doc = parseXML(conn.getInputStream()); //checar importacion
                marcas = parseMarca(doc.getDocumentElement());
            }
            else if(responseCode == HttpURLConnection.HTTP_CONFLICT){
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(conn != null){
                conn.disconnect();
            }
        }
        return marcas;
    }
    private ArrayList<Marca> parseMarca(Element raiz){
        ArrayList<Marca> marcas = new ArrayList<Marca>();
        NodeList items = raiz.getElementsByTagName("marca");
        for(int i=0; i < items.getLength(); i++){
            Node nodoMarca = items.item(i);
            Marca marca = new Marca();
            //Recorremos todos los hijos que tenga el nodo libro

            for(int j = 0; j < nodoMarca.getChildNodes().getLength(); j++){
                Node nodoActual = nodoMarca.getChildNodes().item(j);
                if(nodoActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodoActual.getNodeName().equalsIgnoreCase("id")){
                        marca.setId(nodoActual.getChildNodes().item(0).getNodeValue());
                    }
                    else if(nodoActual.getNodeName().equalsIgnoreCase("nombre")){
                        marca.setNombre(nodoActual.getChildNodes().item(0).getNodeValue());
                    }
                }
            }
            marcas.add(marca);
        }
        return marcas;
    }

    //LISTO
    public ArrayList<Tipo> leerTipos(){
        HttpURLConnection conn = null;
        ArrayList<Tipo> tipos = null;

        try{
            URL url = new URL(archivoXMLTipos);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();

            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                Document doc = parseXML(conn.getInputStream()); //checar importacion
                tipos = parseTipo(doc.getDocumentElement());
            }
            else if(responseCode == HttpURLConnection.HTTP_CONFLICT){
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(conn != null){
                conn.disconnect();
            }
        }
        return tipos;
    }
    private ArrayList<Tipo> parseTipo(Element raiz){
        ArrayList<Tipo> tipos = new ArrayList<Tipo>();
        NodeList items = raiz.getElementsByTagName("tipo");
        for(int i=0; i < items.getLength(); i++){
            Node nodoTipo = items.item(i);
            Tipo tipo = new Tipo();
            //Recorremos todos los hijos que tenga el nodo libro

            for(int j = 0; j < nodoTipo.getChildNodes().getLength(); j++){
                Node nodoActual = nodoTipo.getChildNodes().item(j);
                if(nodoActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodoActual.getNodeName().equalsIgnoreCase("id")){
                        tipo.setId(nodoActual.getChildNodes().item(0).getNodeValue());
                    }
                    else if(nodoActual.getNodeName().equalsIgnoreCase("nombre")){
                        tipo.setNombre(nodoActual.getChildNodes().item(0).getNodeValue());
                    }
                }
            }
            tipos.add(tipo);
        }
        return tipos;
    }

    private Document parseXML(InputStream stream) throws ParserConfigurationException, IOException, SAXException{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(stream);
        return document;
    }

    private void imprimeCategorias(){
        for (Categoria cat : categorias) {
            System.out.println("ID: " + cat.getId() + " SECCION: " + cat.getSeccion());
        }
    }
    private void imprimeMarcas(){
        for (Marca marca : marcas) {
            System.out.println("ID: " + marca.getId() + " NOMBRE: " + marca.getNombre());
        }
    }
    private void imprimeTipos(){
        for (Tipo tipo : tipos) {
            System.out.println("ID: " + tipo.getId() + " NOMBRE: " + tipo.getNombre());
        }
    }





}