package com.example.webprojectbackend.persistenza.dao;

import com.example.webprojectbackend.persistenza.model.Ricetta;

import java.util.List;

public interface RicettaDAO {

    public List<Ricetta> findAll();

    public List<Ricetta> findByNome(String nome);

    public List<Ricetta> findByCategoria(String categoria);

    public List<Ricetta> findByTag(String tag); //tag 1 or tag 2 indifferente
    public Ricetta findByPrimaryKey(int id);

    public List<Ricetta> findByUsername(String username); //ricette create da un utente
    public void saveOrUpdate(Ricetta recipe);
    public void delete(Ricetta recipe);
}


