package com.example.labevaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.labevaluacion.model.Encuestados;

public class ListaEncuestadosActivity extends AppCompatActivity {

    private ListView lsEncuestados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_encuestados);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lsEncuestados = (ListView)findViewById(R.id.lsv_ListaEncuestados);

        ArrayAdapter<Encuestados> adapterEncuestados = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, RegistrarActivity.encuestados);
        lsEncuestados.setAdapter(adapterEncuestados);
        adapterEncuestados.notifyDataSetChanged();
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