package com.example.webprojectbackend.persistenza.model;

public class Utente {
    private static Utente instance = null;
    private static String userCode; //codice univoco dell'utente, lo dà Firebase
    private static String tipo; //admin o user

    private static String email, nome;
    public Utente() {}

    public Utente(String userCode, String tipo, String email, String nome) {
        this.userCode = userCode;
        this.tipo = tipo;
        this.email = email;
        this.nome = nome;

    }

    public static Utente getInstance() {
        if (instance == null) {
            instance = new Utente();
        }
        return instance;
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
        instance = null;
        this.userCode = null;
        this.tipo = null;
        this.email = null;
        this.nome = null;
    }

    public static void setInstance(Utente utente){
        instance = utente;
    }

    public void setInstance(String userCode, String tipo, String email, String nome){
        instance = new Utente(userCode, tipo, email, nome);
    }


}
