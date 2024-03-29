package com.example.portalberita.model;


import com.google.gson.annotations.SerializedName;


public class DataBeritaItem{

	@SerializedName("penulis_berita")
	private String penulisBerita;

	@SerializedName("image_berita")
	private String imageBerita;

	@SerializedName("id_berita")
	private String idBerita;

	@SerializedName("judul_berita")
	private String judulBerita;

	@SerializedName("isi_berita")
	private String isiBerita;

	public void setPenulisBerita(String penulisBerita){
		this.penulisBerita = penulisBerita;
	}

	public String getPenulisBerita(){
		return penulisBerita;
	}

	public void setImageBerita(String imageBerita){
		this.imageBerita = imageBerita;
	}

	public String getImageBerita(){
		return imageBerita;
	}

	public void setIdBerita(String idBerita){
		this.idBerita = idBerita;
	}

	public String getIdBerita(){
		return idBerita;
	}

	public void setJudulBerita(String judulBerita){
		this.judulBerita = judulBerita;
	}

	public String getJudulBerita(){
		return judulBerita;
	}

	public void setIsiBerita(String isiBerita){
		this.isiBerita = isiBerita;
	}

	public String getIsiBerita(){
		return isiBerita;
	}
}