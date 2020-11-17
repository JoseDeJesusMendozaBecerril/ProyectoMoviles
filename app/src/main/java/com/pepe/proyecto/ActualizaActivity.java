package com.pepe.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActualizaActivity extends AppCompatActivity {

    Button btnActualiza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualiza);
    }


    public void initComponents(){
        this.btnActualiza = (Button) findViewById(R.id.btnActualizar);
    }

    public void addMethods(){
        this.btnActualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Hola", Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }


}