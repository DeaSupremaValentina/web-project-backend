package com.example.webprojectbackend.persistenza.model;

public class Contatto {
    public String formato, valore;

    public Contatto() {}

    public Contatto(String formato, String valore) {
        this.formato = formato;
        this.valore = valore;
    }

    public String getFormato() {
        return formato;
    }

    public String getValore() {
        return valore;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }
}
