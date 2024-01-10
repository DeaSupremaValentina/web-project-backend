package com.example.webprojectbackend.persistenza.model;

import java.util.List;

public class Ricetta {

    private int codice;
    private String nomeRicetta, categoria, descrizione, ingredienti, procedimento, autore, tag1, tag2;
    private String tempoPreparazione, numeroPersone, difficolta, costo;

    private String linkYoutube, linkSpotify;

    private String pathImmagine;

    private List<Recensione> recensioni;

    private List<Commento> commenti;

    public Ricetta() {}

    public Ricetta(int codice, String nome, String categoria, String descrizione, String ingredienti, String procedimento, String tempoPreparazione, String numeroPersone, String difficolta, String costo, String linkYoutube, String linkSpotify, String pathImmagine, String autore, String tag1, String tag2) {
        this.codice = codice;
        this.nomeRicetta = nome;
        this.categoria = categoria;
        this.descrizione = descrizione;
        this.ingredienti = ingredienti;
        this.procedimento = procedimento;
        this.tempoPreparazione = tempoPreparazione;
        this.numeroPersone = numeroPersone;
        this.difficolta = difficolta;
        this.costo = costo;
        this.linkYoutube = linkYoutube;
        this.linkSpotify = linkSpotify;
        this.pathImmagine = pathImmagine;
        this.autore = autore;
        this.tag1 = tag1;
        this.tag2 = tag2;
    }


    public List<Recensione> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    public List<Commento> getCommenti() {
        return commenti;
    }

    public void setCommenti(List<Commento> commenti) {
        this.commenti = commenti;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNomeRicetta() {
        return nomeRicetta;
    }

    public void setNomeRicetta(String nomeRicetta) {
        this.nomeRicetta = nomeRicetta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getTempoPreparazione() {
        return tempoPreparazione;
    }

    public void setTempoPreparazione(String tempoPreparazione) {
        this.tempoPreparazione = tempoPreparazione;
    }

    public String getNumeroPersone() {
        return numeroPersone;
    }

    public void setNumeroPersone(String numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    public String getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(String difficolta) {
        this.difficolta = difficolta;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }

    public String getLinkSpotify() {
        return linkSpotify;
    }

    public void setLinkSpotify(String linkSpotify) {
        this.linkSpotify = linkSpotify;
    }

    public String getPathImmagine() {
        return pathImmagine;
    }

    public void setPathImmagine(String pathImmagine) {
        this.pathImmagine = pathImmagine;
    }

    public String getAutore() { return autore; }
    public void setAutore(String autore) { this.autore = autore; }

    public String getTag1() { return tag1; }
    public void setTag1(String tag1) { this.tag1 = tag1; }

    public String getTag2() { return tag2; }

    public void setTag2(String tag2) { this.tag2 = tag2; }


}
