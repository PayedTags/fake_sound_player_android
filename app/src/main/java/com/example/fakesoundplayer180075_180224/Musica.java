package com.example.fakesoundplayer180075_180224;

import android.media.Image;

import java.util.Date;

public class Musica {

    private String autor;
    private String titulo;
    private Date segundos;
    private Image capa;

    public Musica(String autor, String titulo, Date segundos, Image capa)
    {
        this.autor = autor;
        this.titulo = titulo;
        this.segundos = segundos;
        this.capa = capa;
    }

    public Musica(String autor, String titulo, Date segundos)
    {
        this.autor = autor;
        this.titulo = titulo;
        this.segundos = segundos;
    }

}
