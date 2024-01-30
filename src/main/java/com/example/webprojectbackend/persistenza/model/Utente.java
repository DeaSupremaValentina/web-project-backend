package com.example.webprojectbackend.persistenza.model;

public class Utente {
    //se ne doveva occupare Firebase
    private static String userCode; //codice univoco dell'utente, lo dà Firebase
    private String tipo; //admin o user

    private String email, nome;
    public Utente() {}

    public Utente(String userCode, String tipo, String email, String nome) {
        this.userCode = userCode;
        this.tipo = tipo;
        this.email = email;
        this.nome = nome;

    }

    public static String getUserCode() {
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

}
