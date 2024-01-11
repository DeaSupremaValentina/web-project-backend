package com.example.webprojectbackend.persistenza.model;

public class Recensione {
    //in riferimento alla tabella valutazioni del db
    private int codiceRicetta, codiceValutazione;
    private int voto;

    public Recensione() {}

    public Recensione(int codiceRicetta, int voto) {
        this.codiceRicetta = codiceRicetta;
        this.voto = voto;
    }

    public int getCodiceRicetta() {
        return codiceRicetta;
    }

    public int getVoto() {
        return voto;
    }

    public void setCodiceRicetta(int codiceRicetta) {
        this.codiceRicetta = codiceRicetta;
    }

    public void setVoto(int voto) {
        if (voto < 0 || voto > 5)
            throw new IllegalArgumentException("Il voto deve essere compreso tra 0 e 5");
        this.voto = voto;
    }

    public int getCodiceValutazione() {
        return codiceValutazione;
    }

    public void setCodiceValutazione(int codiceValutazione) {
        this.codiceValutazione = codiceValutazione;
    }

}
