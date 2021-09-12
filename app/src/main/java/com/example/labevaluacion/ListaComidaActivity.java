package com.example.labevaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaComidaActivity extends AppCompatActivity {

    int contador = 0;

    private ListView ls_ListaComida;
    private Button bt_finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comida);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ls_ListaComida = (ListView)findViewById(R.id.lsv_ListaComida);
        bt_finalizar = (Button)findViewById(R.id.btn_Finalizar);

        String carnes [] = {"res", "buey", "vaca", "roja", "cerdo"};
        ArrayAdapter<String> adapterCarnes = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, carnes);
        ls_ListaComida.setAdapter(adapterCarnes);


        ls_ListaComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                contador ++;
            }
        });

        bt_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador > 0){
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