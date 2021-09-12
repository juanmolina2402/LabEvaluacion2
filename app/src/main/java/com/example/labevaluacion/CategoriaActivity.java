package com.example.labevaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CategoriaActivity extends AppCompatActivity {
    RadioButton rbCarnes, rbEnsalada, rbFrutas, cat;
    RadioGroup categorias;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rbCarnes = findViewById(R.id.rdb_carnes);
        rbEnsalada = findViewById(R.id.rdb_ensaladas);
        rbFrutas = findViewById(R.id.rdb_frutas);
        nombre=getIntent().getStringExtra("Nombre");
        categorias= findViewById(R.id.rdg_categoria);
    }
    public void Siguiente(View view){
        int id= categorias.getCheckedRadioButtonId();
        cat= findViewById(id);
        if(rbCarnes.isChecked() || rbEnsalada.isChecked() || rbFrutas.isChecked()){
            Intent i= new Intent(CategoriaActivity.this, ListaComidaActivity.class);
            i.putExtra("Nombre", nombre);
            i.putExtra("Categoria", cat.getText().toString());
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}