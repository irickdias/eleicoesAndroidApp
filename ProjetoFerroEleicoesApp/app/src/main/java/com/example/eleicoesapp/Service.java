package com.example.eleicoesapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service {
    @GET("votos/buscarEleicao/{id}")
    Call<ArrayList<Votos>> buscarEleicao(@Path("id") long id);

    @GET("eleicao/buscar-todos?filtro=")
    Call<ArrayList<Eleicao>> buscarTodos();

    @POST("votos/alterar")
    Call<Votos> votar(@Body Votos votos);
}
