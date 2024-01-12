package com.example.webprojectbackend.persistenza.model;

public class Utente {
    //se ne doveva occupare Firebase
    private String userCode; //codice univoco dell'utente, lo dà Firebase
    private String tipo; //admin o user

    private String email, nome;
    private String pathImmagine;
    public Utente() {}

    public Utente(String userCode, String tipo) {
        this.userCode = userCode;
        this.tipo = tipo;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getTipo() {
        return tipo;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
