package com.example.webprojectbackend.persistenza.dao;

import com.example.webprojectbackend.persistenza.model.Recensione;

import java.util.List;

public interface ValutazioneDAO {

    public void save(Recensione valutazione);
    public void delete(Recensione valutazione);

    public void deleteValutazioniRicetta(int codiceRicetta);

    public List<Recensione> getValutazioniRicetta(int codiceRicetta);
    public int getValutazioneMedia(int codiceRicetta);
    public int getNumeroValutazioni(int codiceRicetta);

}
