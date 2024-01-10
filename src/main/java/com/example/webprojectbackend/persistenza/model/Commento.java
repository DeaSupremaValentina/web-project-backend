package com.example.webprojectbackend.persistenza.model;

public class Commento {
    String username, contenuto;
    int codiceRicetta;
    int codiceCommento;

    public Commento() {}

    public Commento (String username, String contenuto, int codiceRicetta, int codiceCommento) {
        this.username = username;
        this.contenuto = contenuto;
        this.codiceRicetta = codiceRicetta;
        this.codiceCommento = codiceCommento;
    }

    public String getUsername() {
        return username;
    }

    public String getContenuto() {
        return contenuto;
    }

    public int getCodiceRicetta() {
        return codiceRicetta;
    }

    public int getCodiceCommento() {
        return codiceCommento;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public void setCodiceRicetta(int codiceRicetta) {
        this.codiceRicetta = codiceRicetta;
    }


    public void setCodiceCommento(int codiceCommento) {
        this.codiceCommento = codiceCommento;
    }
}
