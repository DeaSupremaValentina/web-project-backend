package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.dao.ContattoDAO;
import com.example.webprojectbackend.persistenza.model.Contatto;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContattiDAOPostgres implements ContattoDAO {
   Connection conn;

    public ContattiDAOPostgres(Connection conn)
    {
         this.conn = conn;
    }

    @Override
    public void save(Contatto contatto) {
        String query = "INSERT INTO contatti (formato, valore) VALUES (?, ?)";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, contatto.getFormato());
            st.setString(2, contatto.getValore());
            st.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();

    }
}

    @Override
    public void delete(Contatto contatto) {
        String query = "DELETE FROM contatti WHERE formato = ?";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, contatto.getFormato());
            st.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    @Override
    public void update(Contatto contatto) {

    }

    @Override
    public Contatto findByFormato(String formato) {
        return null;
    }

    @Override
    public List<Contatto> findAll() {
        List<Contatto> contatti = new ArrayList<>();
        String query = "SELECT * FROM contatti";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                Contatto contatto = new Contatto(rs.getString(1), rs.getString(2));
                contatti.add(contatto);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return contatti;
    }
}
