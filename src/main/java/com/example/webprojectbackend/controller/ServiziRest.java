package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.dao.UtenteDAO;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import com.example.webprojectbackend.persistenza.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiziRest {

    @Autowired
    private UtenteDAO utenteDAO;
    @PostMapping("/utente/login")
    public String login(@RequestBody Utente utente){
        if(utenteDAO.getUtenteByEmail(utente.getEmail())==null){
            return "Utente nuovo quindi va salvato nel db";
        }
        else return "Utente già esistente, non deve essere salvato nel db";
    }

    //richieste post a /utente/propostaRicetta (nome fittizio al momento)
    //serve ad aggiornare il db, la tabella daapprovare in particolare
    @PostMapping("/utente/propostaRicetta")
    public String propostaRicetta(@RequestBody Ricetta ricetta){
        DBManager.getInstance().getRicettaDAO().newProposal(ricetta);
        return "new proposal: OK";
    }
}
