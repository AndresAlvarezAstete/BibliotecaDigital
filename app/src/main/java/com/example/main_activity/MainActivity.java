package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private Button button;
    private ProgressBar progress;
    private ImageButton imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.btnLog);
        progress = (ProgressBar)findViewById(R.id.pbBar);
        imagen = (ImageButton)findViewById(R.id.imgGit);

        progress.setVisibility(View.INVISIBLE);

        imagen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute()
        {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 10; i++)
            {
              try
              {
                Thread.sleep(500);
              }
              catch (Exception e)
              {
                  e.printStackTrace();
              }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            progress.setVisibility(View.INVISIBLE);
            lista();
        }
    }

    public void lista()
    {
        ArrayList<String> libros = new ArrayList<String>();

        libros.add("Farenheit");
        libros.add("Revival");
        libros.add("El Alquimista");

        Intent i = new Intent(this, Github_act.class);
        i.putExtra("listaLibros", libros);
        startActivity(i);
    }
}