package com.example.portalberita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.portalberita.Network.ConfigRetrofit;
import com.example.portalberita.model.DataBeritaItem;
import com.example.portalberita.model.ResponseBerita;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView rvBerita = findViewById(R.id.rv_berita);
        rvBerita.setLayoutManager(new LinearLayoutManager(this));
        rvBerita.setHasFixedSize(true);

        ConfigRetrofit configRetrofit = new ConfigRetrofit();
        configRetrofit.service.getDataBerita("tb_berita").enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
//                boolean status = response.body().isStatus();
//                Log.d("dataBerita", String.valueOf(status));

                List<DataBeritaItem> dataBeritaItems = response.body().getDataBerita();

                BeritaAdapter adapter = new BeritaAdapter(MainActivity.this, dataBeritaItems);
                adapter.notifyDataSetChanged();
                rvBerita.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                Log.d("dataBerita",t.getMessage());

            }
        });


    }
}
