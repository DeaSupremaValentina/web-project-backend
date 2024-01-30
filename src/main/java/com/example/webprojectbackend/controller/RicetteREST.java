package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RicetteREST {
    //per la singola ricetta, info trovate tramite id
    @GetMapping("/ricette/{id}")
    public Ricetta getRicettaByID(int id){
        return DBManager.getInstance().getRicettaDAO().findByPrimaryKey(id);
    }

    //per le ricette trovate tramite nome
    @GetMapping("/ricette/{nome}")
    public List<Ricetta> getRicettaByNome(String nome){
        return DBManager.getInstance().getRicettaDAO().findByNome(nome);
    }

    //per le ricette trovate tramite categoria
    @GetMapping("/ricette/{categoria}")
    public List<Ricetta> getRicettaByCategoria(String categoria){
        return DBManager.getInstance().getRicettaDAO().findByCategoria(categoria);
    }

    //per le ricette trovate tramite tag
    @GetMapping("/ricette/{tag}")
    public List<Ricetta> getRicettaByTag(String tag){
        return DBManager.getInstance().getRicettaDAO().findByTag(tag);
    }

    //per tutte le ricette
    @GetMapping("/tutteLeRicette")
    public List<Ricetta> getAllRicette(){
        return DBManager.getInstance().getRicettaDAO().findAll();
    }

    //Post per aggiungere nuove ricette
    @PostMapping
    public void addRicetta(@RequestBody Ricetta ricetta){
        DBManager.getInstance().getRicettaDAO().save(ricetta);
    }

    //Post per modificare ricette
    @PostMapping
    public void updateRicetta(@RequestBody Ricetta ricetta){
        DBManager.getInstance().getRicettaDAO().update(ricetta);
    }

    //Post per eliminare ricette
    @PostMapping
    public void deleteRicetta(@RequestBody Ricetta ricetta){
        DBManager.getInstance().getRicettaDAO().delete(ricetta);
    }


}
