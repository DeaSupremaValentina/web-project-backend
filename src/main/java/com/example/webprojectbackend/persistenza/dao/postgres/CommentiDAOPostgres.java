package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.dao.CommentoDAO;
import com.example.webprojectbackend.persistenza.model.Commento;
import com.example.webprojectbackend.persistenza.model.Ricetta;

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
                commento.setContenuto(rs.getString("contenuto"));
                commento.setCodiceCommento(rs.getInt("codice"));
                commenti.add(commento);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    return commenti;
    }

    @Override
    public List<Commento> findByCodiceRicetta(int codiceRicetta) {
        List <Commento> commenti = new ArrayList<>();
        String query = "select * from commenti where ricetta = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, codiceRicetta);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Commento commento = new Commento();
                commento.setCodiceRicetta(rs.getInt("ricetta"));
                commento.setUsername(rs.getString("username"));
                commento.setContenuto(rs.getString("contenuto"));
                commento.setCodiceCommento(rs.getInt("codice"));
                commenti.add(commento);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return commenti;
    }

    @Override
    public void save(Commento commento) {
        String query = "insert into commenti (ricetta, username, contenuto) values (?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, commento.getCodiceRicetta());
            st.setString(2, commento.getUsername());
            st.setString(3, commento.getContenuto());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Commento commento) {
        String query = "update commenti set contenuto = ? and username = ? where codice = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, commento.getContenuto());
            st.setString(2, commento.getUsername());
            st.setInt(3, commento.getCodiceCommento());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void delete(Commento commento) {
        String query = "delete from commenti where codice = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, commento.getCodiceCommento());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteByUser(String username) {
        String query = "delete from commenti where username = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByRicetta(int codiceRicetta) {
        String query = "delete from commenti where ricetta = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, codiceRicetta);
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
