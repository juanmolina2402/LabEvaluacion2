package com.example.labevaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.labevaluacion.model.Encuestados;

import java.util.ArrayList;

public class ListaComidaActivity extends AppCompatActivity {

    int contador = 0;

    private ListView ls_ListaComida;
    private Button bt_finalizar;
    private String categoria, nombre, plato;

    public static ArrayList<Encuestados> encuestados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comida);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if(encuestados == null){
            encuestados = new ArrayList<>();
        }

        ls_ListaComida = (ListView)findViewById(R.id.lsv_ListaComida);
        bt_finalizar = (Button)findViewById(R.id.btn_Finalizar);
        nombre=getIntent().getStringExtra("Nombre");
        categoria = getIntent().getStringExtra("Categoria");

        String carnes [] = {"Alitas de pollo", "Chuletas de cerdo", "Carne asada", "Pechugas de pollo"};
        String ensaladas [] = {"Ensalada de pollo", "Ensalada de atún", "Ensalada Cesar", "Ensalada caprese"};
        String frutas [] = {"Uvas", "Manzanas", "Fresas", "Mandarinas"};

        if(categoria.equals("Carnes")){
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, carnes);
            ls_ListaComida.setAdapter(adapter);
        } if(categoria.equals("Ensaladas")){
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ensaladas);
            ls_ListaComida.setAdapter(adapter);
        } if(categoria.equals("Frutas")){
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, frutas);
            ls_ListaComida.setAdapter(adapter);
        }

        ls_ListaComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = ls_ListaComida.getItemAtPosition(i).toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaComidaActivity.this);
                builder.setTitle("Confirmacion");
                builder.setMessage("¿Estas seguro?");
                builder.setPositiveButton("Aceptar",(dialog,wich)-> plato = s);
                builder.setNegativeButton("Cancelar",null );
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        bt_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plato.length() > 0){
                    contador ++;
                }
                if(contador > 0){
                    encuestados.add(new Encuestados(nombre, plato));
                    startActivity(new Intent(ListaComidaActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(ListaComidaActivity.this, "Por favor seleccione un item", Toast.LENGTH_LONG).show();
                }
            }
        });
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