package com.example.eleicoesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VotosAdapter extends ArrayAdapter<Votos> {
    private int layout;
    private Votos votos;
    public VotosAdapter(Context context, int resource, List<Votos> votos)
    {
        super(context, resource, votos);
        this.layout=resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.layout,parent,false);
        }

        TextView nome = (TextView)convertView.findViewById(R.id.can_nome);
        TextView num = (TextView)convertView.findViewById(R.id.can_num);
        TextView partido = (TextView)convertView.findViewById(R.id.can_partido);
        Button bt = (Button) convertView.findViewById(R.id.btVotar);
        //TextView tx = (TextView)convertView.findViewById(R.id.txSelecione);

        //Votos votos = this.getItem(position);
        //int pos = position-1;
        votos = this.getItem(position);
        //System.out.println(position);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Item clicado: " + position, Toast.LENGTH_SHORT).show();
                Votos v = getItem(position);
                Call<Votos> call = new RetrofitConfig().getService().votar(v);

                call.enqueue(new Callback<Votos>() {
                    @Override
                    public void onResponse(Call<Votos> call, Response<Votos> response) {
                        Toast.makeText(getContext(), "Voto em " + v.getCandidato().getNome() + " realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Votos> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
            }
        });



        nome.setText(votos.getCandidato().getNome());
        num.setText(""+votos.getCandidato().getNum());
        partido.setText(votos.getCandidato().getPartido().getNome());


        return convertView;
    }
}
