package com.example.portalberita.Network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://localhost/portal_berita/")
            .baseUrl("http://192.168.86.45:8888/portal_berita/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public ApiInterface service = retrofit.create(ApiInterface.class);
}
