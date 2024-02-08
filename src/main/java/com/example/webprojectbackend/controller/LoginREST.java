package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import com.example.webprojectbackend.persistenza.model.Utente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginREST {
    Utente utente = Utente.getInstance();
    @PostMapping("/login")
    public void login(@RequestBody Utente utente){
       this.utente = utente;
        System.out.println("la rest per login");

        if(DBManager.getInstance().getUtenteDAO().getUtenteByUsername(utente.getUserCode()) == null){
            System.out.println(utente.getEmail());
            DBManager.getInstance().getUtenteDAO().save(utente);
        }else{
            this.utente.setUserCode(DBManager.getInstance().getUtenteDAO().getUtenteByEmail(utente.getEmail()).getUserCode());
        }
        if(Objects.equals(utente.getEmail(), "valentinaricioppo@gmail.com")){
            utente.setTipo("admin");
        }

        System.out.println("è andato il login");

    }

    @GetMapping("/tipoUtente")
    public String getTipoUtente(){
        return utente.getTipo();
    }

   @PostMapping("/logout")
    public void logout()
   {
         utente = null;
         Utente.getInstance().logout();
   }

}


