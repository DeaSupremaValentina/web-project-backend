package com.example.webprojectbackend.persistenza.dao;

import com.example.webprojectbackend.persistenza.model.Ricetta;

import java.util.List;

public interface RicettaDAO {

    public List<Ricetta> findAll();
    public Ricetta findByPrimaryKey(int id);
    public void saveOrUpdate(Ricetta recipe);
    public void delete(Ricetta recipe);
}


