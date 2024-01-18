package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.dao.UtenteDAO;
import com.example.webprojectbackend.persistenza.model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtentiDAOPostgres implements UtenteDAO {

    Connection conn;

    public UtentiDAOPostgres(Connection conn) {
        this.conn = conn;
    }

    public UtentiDAOPostgres(){}
    @Override
    public void save(Utente utente) {
        String query = "INSERT INTO utenti (username, nome, email, tipo, pathImage) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, utente.getUserCode());
            st.setString(2, utente.getNome());
            st.setString(3, utente.getEmail());
            st.setString(4, utente.getTipo());
            st.setString(5, utente.getPathImmagine());
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateImage(Utente utente, String newImage) {
        String query = "UPDATE utenti SET pathImage = ? WHERE username = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, newImage);
            st.setString(2, utente.getUserCode());
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Utente utente) {
        String query = "DELETE FROM user WHERE username = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, utente.getUserCode());
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Utente getUtenteByUsername(String username) {
        String query = "SELECT * FROM user WHERE username = ?";
        Utente utente = null;
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                utente = new Utente();
                utente.setUserCode(rs.getString("username"));
                utente.setNome(rs.getString("nome"));
                utente.setEmail(rs.getString("email"));
                utente.setTipo(rs.getString("tipo"));
                utente.setPathImmagine(rs.getString("pathImage"));
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return utente;
    }

    @Override
    public Utente getUtenteByEmail(String email) {
        String query = "SELECT * FROM user WHERE email = ?";
        Utente utente = null;
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                utente = new Utente();
                utente.setUserCode(rs.getString("username"));
                utente.setNome(rs.getString("nome"));
                utente.setEmail(rs.getString("email"));
                utente.setTipo(rs.getString("tipo"));
                utente.setPathImmagine(rs.getString("pathImage"));
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


        return utente;
    }

    @Override
    public void setUtenteAdmin(String username) {
        String query = "UPDATE user SET tipo = 'admin' WHERE username = ?";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void setUtenteUser(String username) {
        String query = "UPDATE user SET tipo = 'user' WHERE username = ?";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
