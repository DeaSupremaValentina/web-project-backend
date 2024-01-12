package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ServiziRest {

    //richieste post a /utente/propostaRicetta (nome fittizio al momento)
    //serve ad aggiornare il db, la tabella daapprovare in particolare
    @PostMapping("/utente/propostaRicetta")
    public String propostaRicetta(@RequestBody Ricetta ricetta){
        DBManager.getInstance().getRicettaDAO().newProposal(ricetta);
        return "new proposal: OK";
    }
}
