package com.example.webprojectbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public void saveCommento(@RequestBody String json, String comm) {
        @SuppressWarnings("deprecation")
        JsonElement jsonElement = new JsonParser().parse(json);
        int codiceRicetta = jsonElement.getAsJsonObject().get("id").getAsInt();
        String commentoFromjson = jsonElement.getAsJsonObject().get("comm").getAsString();
        Commento commento = new Commento();
        commento.setCodiceRicetta(codiceRicetta);
        commento.setContenuto(commentoFromjson);
        commento.setUsername(Utente.getInstance().getNome());
        DBManager.getInstance().getCommentoDAO().save(commento);
    }


}
