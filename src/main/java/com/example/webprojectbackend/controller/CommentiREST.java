package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Commento;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import com.example.webprojectbackend.persistenza.model.Utente;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentiREST
{
    @GetMapping("/commenti/{id}")
    public List<Commento> getCommentiUtente(String user)
    {
        return DBManager.getInstance().getCommentoDAO().findByUser(user);
    }

    @PostMapping("/salvaCommento")
    public void saveCommento(int codiceRicetta, String comm) {
        Commento commento = new Commento();
        commento.setCodiceRicetta(codiceRicetta);
        commento.setContenuto(comm);
        commento.setUsername(Utente.getInstance().getUserCode());
        DBManager.getInstance().getCommentoDAO().save(commento);
    }


}
