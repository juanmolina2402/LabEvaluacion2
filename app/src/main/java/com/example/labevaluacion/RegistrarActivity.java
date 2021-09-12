package com.example.labevaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.labevaluacion.model.Encuestados;

import java.util.ArrayList;

public class RegistrarActivity extends AppCompatActivity {
    private EditText ed_Nombre, ed_Edad;
    private RadioButton rd_Masculino, rd_Femenino, rd_Otro;
    private Button bt_Siguiente;
    private RadioGroup rd_grupo_genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ed_Nombre = (EditText) findViewById(R.id.edt_nombre);
        ed_Edad = (EditText) findViewById(R.id.edt_edad);
        rd_Masculino = (RadioButton) findViewById(R.id.rdb_masculino);
        rd_Femenino = (RadioButton) findViewById(R.id.rdb_femenino);
        rd_Otro = (RadioButton) findViewById(R.id.rdb_otro);
        bt_Siguiente = (Button) findViewById(R.id.btn_siguiente);
        rd_grupo_genero = (RadioGroup) findViewById(R.id.rdb_group_genero);


        //encuestados = new ArrayList<>();
    }
    public void Validar(View view){
        try {
            if (ed_Nombre.length() <= 0 || ed_Edad.length() <= 0 || rd_grupo_genero.getCheckedRadioButtonId() == -1) {
                Toast.makeText(RegistrarActivity.this, "Por favor llene todos los campos", Toast.LENGTH_LONG).show();

            } else {
                Intent i= new Intent(this, CategoriaActivity.class);
                i.putExtra("Nombre", ed_Nombre.getText().toString());
                startActivity(i);

            }
        }catch (IllegalArgumentException ex){
            Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
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