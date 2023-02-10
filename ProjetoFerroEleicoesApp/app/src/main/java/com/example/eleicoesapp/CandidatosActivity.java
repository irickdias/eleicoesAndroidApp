package com.example.eleicoesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CandidatosActivity extends AppCompatActivity {
    private ListView listview;
    private ArrayList<Candidato> candidatos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listaCandidato);



        //listView.setAdapter(new CandidatosAdapter(this,
        //        R.layout.item_list_view, parcelas));
    }
}
