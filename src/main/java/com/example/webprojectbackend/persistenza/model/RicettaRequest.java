package com.example.webprojectbackend.persistenza.model;

public class RicettaRequest {
    private int codiceRicetta;
    private String codiceUtente;

    // Costruttore vuoto necessario per il deserializzazione JSON
    public RicettaRequest() {}

    // Costruttore con parametri
    public RicettaRequest(int codiceRicetta, String codiceUtente) {
        this.codiceRicetta = codiceRicetta;
        this.codiceUtente = codiceUtente;
    }

    // Metodi getter e setter
    public int getCodiceRicetta() {
        return codiceRicetta;
    }

    public void setCodiceRicetta(int codiceRicetta) {
        this.codiceRicetta = codiceRicetta;
    }

    public String getCodiceUtente() {
        return codiceUtente;
    }

    public void setCodiceUtente(String codiceUtente) {
        this.codiceUtente = codiceUtente;
    }
}
