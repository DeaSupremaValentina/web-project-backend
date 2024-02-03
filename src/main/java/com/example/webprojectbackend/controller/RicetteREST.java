package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RicetteREST {
    //per la singola ricetta, info trovate tramite id
    @GetMapping("/ricette_id/{id}")
    public Ricetta getRicettaByID(@PathVariable int id){
        return DBManager.getInstance().getRicettaDAO().findByPrimaryKey(id);
    }

    //per le ricette trovate tramite nome
    @GetMapping("/ricette_nome/{nome}")
    public List<Ricetta> getRicettaByNome(String nome){
        return DBManager.getInstance().getRicettaDAO().findByNome(nome);
    }

    //per le ricette trovate tramite categoria, es. "Primi" o "Secondi" ecc.
    @GetMapping("/ricette_categoria/{categoria}")
    public List<Ricetta> getRicettaByCategoria(String categoria){
        return DBManager.getInstance().getRicettaDAO().findByCategoria(categoria);
    }

    //per le ricette trovate tramite tag
    @GetMapping("/ricette_tag/{tag}")
    public List<Ricetta> getRicettaByTag(String tag){
        return DBManager.getInstance().getRicettaDAO().findByTag(tag);
    }

    //per tutte le ricette
    @GetMapping("/tutteLeRicette")
    public List<Ricetta> getAllRicette()
    {
        System.out.println("nell'endpoint");
        // return DBManager.getInstance().getRicettaDAO().findAll();
        return DBManager.getInstance().getRicettaDAO().findAllLazy();
    }

    //Post per aggiungere nuove ricette
    @PostMapping("/aggiungi")
    public void addRicetta(@RequestBody Ricetta ricetta){
        DBManager.getInstance().getRicettaDAO().save(ricetta);
    }

    //Post per modificare ricette
    @PostMapping("/aggiorna")
    public void updateRicetta(@RequestBody Ricetta ricetta){
        DBManager.getInstance().getRicettaDAO().update(ricetta);
    }

    //Post per eliminare ricette
    @PostMapping("/elimina")
    public void deleteRicetta(@RequestBody Ricetta ricetta){
        DBManager.getInstance().getRicettaDAO().delete(ricetta);
    }

    //get per cercare ricette tramite stringa inserita nella barra di ricerca
    @GetMapping
    public List<Ricetta> searchRicetta(String cercata){
        return DBManager.getInstance().getRicettaDAO().genericSearch(cercata);
    }

}
