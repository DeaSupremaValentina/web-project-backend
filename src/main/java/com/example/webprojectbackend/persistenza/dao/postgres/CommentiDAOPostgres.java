package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.dao.CommentoDAO;
import com.example.webprojectbackend.persistenza.model.Commento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentiDAOPostgres implements CommentoDAO {

    Connection conn;
    public CommentiDAOPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Commento> findByUser(String username) {
        List <Commento> commenti = new ArrayList<>();
        String query = "select * from commenti where username = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Commento commento = new Commento();
                commento.setCodiceRicetta(rs.getInt("ricetta"));
                commento.setUsername(rs.getString("username"));
                commento.setTesto(rs.getString("testo"));
                commento.setData(rs.getDate("data"));
                commenti.add(commento);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Commento> findByCodiceRicetta(int codiceRicetta) {
        return null;
    }

    @Override
    public void saveOrUpdate(Commento commento) {

    }

    @Override
    public void delete(Commento commento) {

    }
}
