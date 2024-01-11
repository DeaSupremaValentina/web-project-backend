package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.dao.ValutazioneDAO;
import com.example.webprojectbackend.persistenza.model.Recensione;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValutazioniDAOPostgres implements ValutazioneDAO
{
    Connection conn;
    public ValutazioniDAOPostgres(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void save(Recensione valutazione) {
        String query = "INSERT INTO valutazioni (ricetta, voto, codice) VALUES (?, ?, ?)";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, valutazione.getCodiceRicetta());
            st.setInt(2, valutazione.getVoto());
            st.setInt(3, valutazione.getCodiceValutazione());
            st.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Recensione valutazione) {
        String query = "DELETE FROM valutazioni WHERE codice = ?";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, valutazione.getCodiceValutazione());
            st.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteValutazioniRicetta(int codiceRicetta) {
        String query = "DELETE FROM valutazioni WHERE ricetta = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, codiceRicetta);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Recensione> getValutazioniRicetta(int codiceRicetta) {
        List<Recensione> valutazioni = new ArrayList<>();
        String query = "SELECT * FROM valutazioni WHERE ricetta = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, codiceRicetta);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Recensione valutazione = new Recensione();
                valutazione.setCodiceRicetta(rs.getInt("ricetta"));
                valutazione.setVoto(rs.getInt("voto"));
                valutazione.setCodiceValutazione(rs.getInt("codice"));
                valutazioni.add(valutazione);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return valutazioni;
    }

    @Override
    public int getValutazioneMedia(int codiceRicetta) {
        int media = 0;
        String query = "SELECT AVG(voto) FROM valutazioni WHERE ricetta = ?";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, codiceRicetta);
            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                media = rs.getInt(1);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return media;
    }

    @Override
    public int getNumeroValutazioni(int codiceRicetta) {
        int n=0;
        String query = "SELECT COUNT(*) FROM valutazioni WHERE ricetta = ?";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, codiceRicetta);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                n = rs.getInt(1);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return n;
    }

}
