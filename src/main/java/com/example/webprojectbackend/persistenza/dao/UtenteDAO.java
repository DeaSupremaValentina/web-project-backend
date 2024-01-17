package com.example.webprojectbackend.persistenza.dao;

import com.example.webprojectbackend.persistenza.model.Utente;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteDAO {

    public void save(Utente utente);

    public void updateImage(Utente utente, String newImage);

    public void delete (Utente utente);

    public Utente getUtenteByUsername(String username);

    public Utente getUtenteByEmail(String email);

    public void setUtenteAdmin(String username);

    public void setUtenteUser(String username);
}
