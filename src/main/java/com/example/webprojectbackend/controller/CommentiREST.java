package com.example.webprojectbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Commento;
import com.example.webprojectbackend.persistenza.model.Utente;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@RestController
public class CommentiREST
{
    @GetMapping("/commenti/{id}")
    public List<Commento> getCommentiUtente(String user)
    {
        return DBManager.getInstance().getCommentoDAO().findByUser(user);
    }

    @PostMapping("/salvaCommento")
    public void saveCommento(@RequestParam int id, String comm, String user) {
        @SuppressWarnings("deprecation")

        int codiceRicetta = id;
        Commento commento = new Commento();
        System.out.println("codice ricetta: " + codiceRicetta);
        commento.setCodiceRicetta(codiceRicetta);
        commento.setContenuto(comm);
        commento.setUsername(DBManager.getInstance().getUtenteDAO().getUtenteByUsername(user).getNome());
        DBManager.getInstance().getCommentoDAO().save(commento);
    }


}
