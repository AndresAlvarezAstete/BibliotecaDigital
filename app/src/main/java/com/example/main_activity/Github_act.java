package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Biblioteca.Libros;

public class Github_act extends AppCompatActivity
{

    private Spinner spn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spn = (Spinner)findViewById(R.id.spnLibros);
        txt = (TextView)findViewById(R.id.txtPrecios);

        ArrayList<String> listaLibros = (ArrayList<String>) getIntent().getSerializableExtra("listaLibros");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaLibros);
        spn.setAdapter(adapt);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                Calcular();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });
    }

    private void Calcular()
    {
        Libros precios = new Libros();

        String nombres = spn.getSelectedItem().toString();

        if (nombres.equals("Farenheit"))
        {
            txt.setText("El valor de Farenheit es: " + precios.getFarenheit());
        }

        if (nombres.equals("Revival"))
        {
            txt.setText("El valor de Revival es: " + precios.getRevival());
        }

        if (nombres.equals("El Alquimista"))
        {
            txt.setText("El valor de El Alquimista es: " + precios.getElAlquimista());
        }
    }
}