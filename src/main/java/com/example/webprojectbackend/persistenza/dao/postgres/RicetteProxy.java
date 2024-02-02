package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.dao.CommentoDAO;
import com.example.webprojectbackend.persistenza.dao.RicettaDAO;
import com.example.webprojectbackend.persistenza.model.Commento;
import com.example.webprojectbackend.persistenza.model.Ricetta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RicetteProxy extends Ricetta
{
    Connection conn; //connessione al database

    public RicetteProxy(Connection conn)
    {
        this.conn = conn;
    }

    @Override
    public List<Commento> getCommenti()
    {
        List<Commento> commenti = super.getCommenti();

        if (super.getCommenti() == null)
        {
            String query = "SELECT * FROM commenti c, ricette r WHERE r.codice = ? AND c.ricetta = r.codice";
            try
            {
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, getCodice());
                ResultSet rs = st.executeQuery();
                while (rs.next())
                {
                    Commento commento = new Commento();
                    commento.setCodiceCommento(rs.getInt("codice"));
                    commento.setContenuto(rs.getString("contenuto"));
                    commento.setUsername(rs.getString("username"));
                    commento.setCodiceRicetta(rs.getInt("ricetta"));
                    commenti.add(commento);
                }
            }
            catch (SQLException e)
                { throw new RuntimeException(e); }

            super.setCommenti(commenti);
            return commenti;
        }

        else
            { return super.getCommenti(); }
    }


}
