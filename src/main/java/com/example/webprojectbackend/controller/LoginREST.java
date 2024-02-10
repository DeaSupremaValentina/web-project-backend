package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import com.example.webprojectbackend.persistenza.model.Utente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class LoginREST {
    Utente utente = new Utente();
    List<Utente> listaUtenti = new ArrayList<>();
    @PostMapping("/login")

    public void login(@RequestBody Utente utente){

        System.out.println(utente.getEmail());
        this.utente = utente;
        System.out.println("la rest per login");
        System.out.println(utente.getEmail());

        if(DBManager.getInstance().getUtenteDAO().getUtenteByUsername(utente.getUserCode()) == null){
            System.out.println(utente.getEmail());
            DBManager.getInstance().getUtenteDAO().save(utente);
        }else{
            this.utente.setUserCode(DBManager.getInstance().getUtenteDAO().getUtenteByEmail(utente.getEmail()).getUserCode());
        }
        System.out.println(utente.getTipo());

        if(Objects.equals(DBManager.getInstance().getUtenteDAO().getUtenteByUsername(utente.getUserCode()).getTipo(), "admin")){
            this.utente.setTipo("admin");
        }


        listaUtenti.add(utente);


        System.out.println("è andato il login");

    }

    @GetMapping("/tipoUtente")
    public String getTipoUtente(){

        return this.utente.getTipo();
    }



}


