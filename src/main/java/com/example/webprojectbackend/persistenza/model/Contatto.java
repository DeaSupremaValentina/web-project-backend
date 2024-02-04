package com.example.webprojectbackend.persistenza.model;

public class Contatto {
    public String email, telefono, spotify, instagram, descr, sedeLegale;

    public Contatto() {
    }

    public Contatto(String email, String telefono, String spotify, String instagram, String descr, String sedeLegale) {
        this.email = email;
        this.telefono = telefono;
        this.spotify = spotify;
        this.instagram = instagram;
        this.descr = descr;
        this.sedeLegale = sedeLegale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getSedeLegale() {
        return sedeLegale;
    }

    public void setSedeLegale(String sedeLegale) {
        this.sedeLegale = sedeLegale;
    }
}

