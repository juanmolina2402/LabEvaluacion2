package com.example.labevaluacion;

import static com.example.labevaluacion.ListaComidaActivity.encuestados;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.labevaluacion.model.Encuestados;

import java.util.ArrayList;

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
        ArrayList<String> Lst= new ArrayList<String>();

        if(lsEncuestados != null){

            for(int i=0;i<encuestados.size();i++)
            {
                String a=encuestados.get(i).getNombre()+" / "+encuestados.get(i).getPlato();
                Lst.add(a);
            }

            ArrayAdapter<Encuestados> adapterEncuestados = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Lst);
            lsEncuestados.setAdapter(adapterEncuestados);
            adapterEncuestados.notifyDataSetChanged();
        }else{
            Toast.makeText(this, "La lista está vacía", Toast.LENGTH_LONG).show();
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