package com.example.portalberita.Network;

import com.example.portalberita.model.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("lihat_berita.php")
    Call<ResponseBerita> getDataBerita (@Query("table") String namaTable);
}
