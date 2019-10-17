package com.example.portalberita;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static String KEY_JUDUL = "judul";
    public static String KEY_PENULIS = "penulis";
    public static String KEY_BERITA = "berita";
    public static String KEY_GAMBAR = "gambar";

    ImageView imgDetail;
    TextView tvDetailPenulis, tvDetailBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgDetail = findViewById(R.id.img_detail);
        tvDetailPenulis = findViewById(R.id.tv_detail_penulis);
        tvDetailBerita = findViewById(R.id.tv_detail_berita);

        String urlImage = "http://192.168.86.45:8888/portal_berita/image/" + getIntent().getStringExtra(KEY_GAMBAR);
        Glide.with(DetailActivity.this).load(urlImage).into(imgDetail);

        tvDetailPenulis.setText(getIntent().getStringExtra(KEY_PENULIS));
        tvDetailBerita.setText(getIntent().getStringExtra(KEY_BERITA));

        getSupportActionBar().setTitle(getIntent().getStringExtra(KEY_JUDUL));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
