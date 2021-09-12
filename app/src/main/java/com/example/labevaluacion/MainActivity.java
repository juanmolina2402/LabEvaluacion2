package com.example.labevaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrarEncuesta(View view){
        startActivity(new Intent(MainActivity.this, RegistrarActivity.class));
    }

    public void listaEncuestados(View view){
        if(ListaComidaActivity.encuestados.isEmpty()) {
            Toast.makeText(this, "La lista está vacía", Toast.LENGTH_LONG).show();
        }else{
            startActivity(new Intent(MainActivity.this, ListaEncuestadosActivity.class));
        }

    }

    public void verDatos(View view){
        startActivity(new Intent(MainActivity.this, DatosActivity.class));
    }
}