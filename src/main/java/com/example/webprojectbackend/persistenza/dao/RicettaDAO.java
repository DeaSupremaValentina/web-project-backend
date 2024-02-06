package com.example.webprojectbackend.persistenza.dao;

import com.example.webprojectbackend.persistenza.model.Commento;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import com.example.webprojectbackend.persistenza.model.Utente;

import java.util.List;

public interface RicettaDAO {

    public List<Ricetta> findAll(); //trova tutte le ricette

    public List<Ricetta> findByNome(String nome); //ricette con nome che contiene la stringa

    public List<Ricetta> findByCategoria(String categoria); //ricette con categoria che contiene la stringa

    public List<Ricetta> findByTag(String tag); //tag 1 or tag 2 indifferente, ricette taggate con tag
    public Ricetta findByPrimaryKey(int id); //trova la ricetta specifica con codice id

    public List<Ricetta> findByUsername(String username); //ricette create da un utente
    public void save(Ricetta recipe); //crea una ricetta

    public boolean update(Ricetta recipe); //modifica una ricetta
    public void delete(Ricetta recipe); //elimina una ricetta


    //query per la tabella delle proposte da approvare:
    public void newProposal(Ricetta recipe); //crea una proposta
    public List<Ricetta> findAllProposals(); //trova tutte le proposte
    public void deleteProposal(Ricetta recipe); //elimina una proposta

    public void saveNewRecipe(int codiceRicetta); //salva una ricetta

    public void unsaveRecipe(int codiceRicetta); //rimuove una ricetta salvata

    //un moderatore può approvare o rifiutare una proposta. vedrà tutte le proposte quindi all'apertura della pagina dedicata
    //si dovrà fare una query che restituisca tutte le proposte, poi quando ne approva una si fa una query che salva la proposta
    // nella tabella ricette, ed una query per eliminare la proposta dalla tabella delle proposte
    //sostanzialmente si fa una sorta di "spostamento"


    public List<Ricetta> findAllLazy(); //ricerca lazy


    public List<Ricetta> genericSearch(String cercata);

    public List<Ricetta> findSavedRecipes(Utente user);
}


