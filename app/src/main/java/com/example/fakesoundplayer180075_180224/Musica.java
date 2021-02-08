package com.example.fakesoundplayer180075_180224;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.Date;

public class Musica {

    private String autor;
    private String titulo;
    private long segundos;
    private int capa;


    public Musica()
    {
        autor = "";
        titulo = "";
        segundos = 0;
        capa = 0;
    }

    public Musica(String autor, String titulo, long segundos, int capa)
    {
        this.autor = autor;
        this.titulo = titulo;
        this.segundos = segundos;
        this.capa = capa;
    }

    public Musica(String autor, String titulo, long segundos)
    {
        this.autor = autor;
        this.titulo = titulo;
        this.segundos = segundos;
        this.capa = 0;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCapa() {
        return capa;
    }

    public long getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
