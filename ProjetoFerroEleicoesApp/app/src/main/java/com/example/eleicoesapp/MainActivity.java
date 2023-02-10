package com.example.eleicoesapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private Spinner cbEleicoes;
    private ArrayList<Candidato> candidatos;
    private ArrayList<Eleicao> eleicoes;
    private ArrayList<Votos> votos;
    private Votos voto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbEleicoes = findViewById(R.id.cbEleicoes);
        listview = findViewById(R.id.listaCandidato);
        //bt = findViewById();
        //System.out.println("iniciou");

        // carrega spinner (comboBox)
        carregarEleicoes();

        /////////////
        // quando escolhe item do spinner, carrega o listView
        cbEleicoes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Eleicao eleicao = (Eleicao) cbEleicoes.getSelectedItem();
                Call<ArrayList<Votos>> call = new RetrofitConfig().getService().buscarEleicao(eleicao.getId());

                call.enqueue(new Callback<ArrayList<Votos>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Votos>> call, Response<ArrayList<Votos>> response) {
                        votos = response.body();
                        ArrayAdapter<Votos> av = new VotosAdapter(MainActivity.this, R.layout.item_list_view, votos);
                        listview.setAdapter(av);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Votos>> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println("--------");
            }
        });

        /*listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                voto = (Votos) listview.getSelectedItem();
                System.out.println("votou");
                return false;
            }
        });*/


    }

    private void carregarEleicoes() {

        Call<ArrayList<Eleicao>> call = new RetrofitConfig().getService().buscarTodos();
        //System.out.println("entrou1111");
        call.enqueue(new Callback<ArrayList<Eleicao>>() {
            @Override
            public void onResponse(Call<ArrayList<Eleicao>> call, Response<ArrayList<Eleicao>> response) {
                //System.out.println(response.body());
                //System.out.println("entrou");
                eleicoes = response.body();
                ArrayAdapter<Eleicao> ae = new ArrayAdapter<Eleicao>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, eleicoes);


                cbEleicoes.setAdapter(ae);
                //System.out.println(ele);
            }

            @Override
            public void onFailure(Call<ArrayList<Eleicao>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}