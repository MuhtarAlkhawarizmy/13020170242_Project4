package com.example.recyclertvshow;

public class TvShow {
    private String nama, desc;
    private int Foto;

    public TvShow(String nama, String desc, int foto) {
        this.nama = nama;
        this.desc = desc;
        Foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public String getDesc() {
        return desc;
    }

    public int getFoto() {
        return Foto;
    }
}
