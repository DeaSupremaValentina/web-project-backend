package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import com.example.webprojectbackend.persistenza.model.Utente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoginREST {
    Utente utente = new Utente();
    @PostMapping("/login")
    public void login(@RequestBody Utente utente){
        utente=this.utente;
        if(DBManager.getInstance().getUtenteDAO().getUtenteByEmail(utente.getEmail()) != null){
            DBManager.getInstance().getUtenteDAO().save(utente);
        }
        System.out.println("è andato il login");

    }

    public Utente getUtente(){
        return utente;
    }

}


