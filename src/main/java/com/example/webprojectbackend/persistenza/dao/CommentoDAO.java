package com.example.webprojectbackend.persistenza.dao;

import com.example.webprojectbackend.persistenza.model.Commento;

import java.util.List;

public interface CommentoDAO {
    public List<Commento> findByUser(String username);
    public List<Commento> findByCodiceRicetta(int codiceRicetta);

    public void save(Commento commento);
    public void update(Commento commento);
    public void delete(Commento commento);
    public void deleteByUser(String username);
    public void deleteByRicetta(int codiceRicetta);

    //mi sembra inutile tbh
    //public List<Commento> findAll();

}
