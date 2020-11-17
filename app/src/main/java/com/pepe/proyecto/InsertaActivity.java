package com.pepe.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EventListener;

public class InsertaActivity extends AppCompatActivity {

    RadioButton radioAutoInsert;
    RadioButton radioRefaccionInsert;
    RadioButton radioSeguroInsert;

    TextView tvop1;
    TextView tvop2;
    TextView tvop3;

    EditText editInsertaOp1;
    EditText editInsertaOp2;
    EditText editInsertaOp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserta);
        initComponents();
        changeVisibility(0);
        this.addMethods();
    }

    public void initComponents(){
        this.tvop1 = (TextView) findViewById(R.id.TextOpInserta1);
        this.tvop2 = (TextView) findViewById(R.id.TextOpInserta2);
        this.tvop3 = (TextView) findViewById(R.id.TextOpInserta3);

        this.editInsertaOp1 = (EditText) findViewById(R.id.editInsertaOp1);
        this.editInsertaOp2 = (EditText) findViewById(R.id.editInsertaOp2);
        this.editInsertaOp3 = (EditText) findViewById(R.id.editInsertaOp3);

        this.radioAutoInsert = (RadioButton) findViewById(R.id.radioAutoInsert);
        this.radioRefaccionInsert = (RadioButton) findViewById(R.id.radioRefaccionInsert);
        this.radioSeguroInsert = (RadioButton) findViewById(R.id.radioSeguroInsert);

    }

    public void changeVisibility(int op){
        int estado = View.INVISIBLE;// = View.INVISIBLE;
        if(op == 1){
            estado = View.VISIBLE;
        }else if(op==0){
            estado = View.INVISIBLE;
        }

        this.tvop1.setVisibility(estado);
        this.tvop2.setVisibility(estado);
        this.tvop3.setVisibility(estado);

        this.editInsertaOp1.setVisibility(estado);
        this.editInsertaOp2.setVisibility(estado);
        this.editInsertaOp3.setVisibility(estado);
    }

    public void changeState(){
        if(radioAutoInsert.isChecked()){ //Auto
            changeVisibility(1);
            this.tvop1.setText("Modelo");
            this.tvop2.setText("Descripcion");
            this.tvop3.setText("Marca");

            this.editInsertaOp1.setInputType(InputType.TYPE_CLASS_NUMBER);
            this.editInsertaOp2.setInputType(InputType.TYPE_CLASS_TEXT);
            this.editInsertaOp3.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else if(radioRefaccionInsert.isChecked()){ //Refaccion
            changeVisibility(1);
            this.tvop1.setText("Nombre");
            this.tvop2.setText("Descripcion");
            this.tvop3.setText("Categoria");

            this.editInsertaOp1.setInputType(InputType.TYPE_CLASS_TEXT);
            this.editInsertaOp2.setInputType(InputType.TYPE_CLASS_TEXT);
            this.editInsertaOp3.setInputType(InputType.TYPE_CLASS_TEXT);

        }
        else if(radioSeguroInsert.isChecked()){
            this.tvop1.setText("Nombre");
            this.tvop2.setText("Descripcion");
            this.tvop3.setText("Tipo");

            this.editInsertaOp1.setInputType(InputType.TYPE_CLASS_TEXT);
            this.editInsertaOp2.setInputType(InputType.TYPE_CLASS_TEXT);
            this.editInsertaOp3.setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }

    public void addMethods(){
        this.radioAutoInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"RadioAuto Selected",Toast.LENGTH_SHORT).show();
                //changeVisibility(1);
                changeState();
            }
        });
        this.radioRefaccionInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"RadioRefaccion Selected",Toast.LENGTH_SHORT).show();
                //changeVisibility(1);
                changeState();
            }
        });
        this.radioSeguroInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"RadioSeguro Selected",Toast.LENGTH_SHORT).show();
                //changeVisibility(1);
                changeState();
            }
        });




    }



}