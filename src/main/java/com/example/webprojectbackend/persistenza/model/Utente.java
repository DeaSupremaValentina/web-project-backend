package com.example.webprojectbackend.persistenza.model;

public class Utente {
    private String userCode; //codice univoco dell'utente, lo dà Firebase
    private String tipo; //admin o user
    private String email, nome;

    public Utente() {}

    public Utente(String userCode, String tipo, String email, String nome) {
        this.userCode = userCode;
        this.tipo = tipo;
        this.email = email;
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void logout(){
        this.userCode = null;
        this.tipo = null;
        this.email = null;
        this.nome = null;
    }
}
