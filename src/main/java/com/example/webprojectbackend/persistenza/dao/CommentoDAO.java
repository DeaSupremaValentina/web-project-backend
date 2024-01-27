package com.example.webprojectbackend.persistenza.dao;

import com.example.webprojectbackend.persistenza.model.Commento;

import java.util.List;

public interface CommentoDAO {
    public List<Commento> findByUser(String username);  //commenti fatti da un utente
    public List<Commento> findByCodiceRicetta(int codiceRicetta); //commenti fatti su una ricetta

    public void save(Commento commento); //crea un commento
    public void update(Commento commento); //modifica un commento
    public void delete(Commento commento); //elimina un commento
    public void deleteByUser(String username); //elimina tutti i commenti di un utente
    public void deleteByRicetta(int codiceRicetta); //elimina tutti i commenti di una ricetta


    //public List<Commento> findAll(); //trova tutti i commenti

}
