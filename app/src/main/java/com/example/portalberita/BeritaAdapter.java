package com.example.portalberita;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.portalberita.model.DataBeritaItem;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {

    Context context;
    List<DataBeritaItem> listBerita;

    public BeritaAdapter(Context context, List<DataBeritaItem> listBerita) {
        this.context = context;
        this.listBerita = listBerita;
    }

    @NonNull
    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_berita, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.ViewHolder holder, int position) {

        final String penulis = listBerita.get(position).getPenulisBerita();
        final String judul = listBerita.get(position).getJudulBerita();
        final String gambar =  listBerita.get(position).getImageBerita();
        final String berita = listBerita.get(position).getIsiBerita();

        holder.itemPenulis.setText(penulis);
        holder.itemJudul.setText(judul);

        String urlImage = "http://192.168.86.45:8888/portal_berita/image/" + gambar;

        Glide.with(context).load(urlImage).into(holder.itemImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra(DetailActivity.KEY_PENULIS, penulis);
                intent.putExtra(DetailActivity.KEY_GAMBAR, gambar);
                intent.putExtra(DetailActivity.KEY_BERITA, berita);
                intent.putExtra(DetailActivity.KEY_JUDUL, judul);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemJudul, itemPenulis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemJudul = itemView.findViewById(R.id.item_judul);
            itemPenulis = itemView.findViewById(R.id.item_penulis);
        }
    }
}
