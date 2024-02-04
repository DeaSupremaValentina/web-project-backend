package com.example.webprojectbackend.persistenza.dao;

import com.example.webprojectbackend.persistenza.model.Contatto;

import java.util.List;

public interface ContattoDAO {
    public void save(Contatto contatto);
    public void delete(Contatto contatto);
    public Contatto findByFormato(String formato);
    public List<Contatto> findAll();
}
