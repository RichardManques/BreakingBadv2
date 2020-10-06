package com.example.breakingbadprueba.model;

public class Character {
    public String name;
    public String apodo;
    public String img;
    public String fecNac;
    public String estado;
    public String ocupacion;
    public String serie;


    public Character(){

    }

    public Character(String name, String apodo, String img, String fecNac, String estado, String ocupacion, String serie) {
        this.name = name;
        this.apodo = apodo;
        this.img = img;
        this.fecNac = fecNac;
        this.estado = estado;
        this.ocupacion = ocupacion;
        this.serie = serie;
    }
}

