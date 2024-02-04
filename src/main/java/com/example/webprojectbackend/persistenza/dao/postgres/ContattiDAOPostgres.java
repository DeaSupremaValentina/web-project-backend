package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.dao.ContattoDAO;
import com.example.webprojectbackend.persistenza.model.Contatto;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContattiDAOPostgres implements ContattoDAO {
    Connection conn;

    public ContattiDAOPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Contatto findAll() {
        System.out.println("la query sta per partire");
        Contatto contatto = new Contatto();
        List<String> stringhe = new ArrayList<>();
        String query = "SELECT * FROM contatti";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("valore"));
                stringhe.add(rs.getString("valore"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        contatto.setEmail(stringhe.get(0));
        contatto.setTelefono(stringhe.get(1));
        contatto.setSpotify(stringhe.get(2));
        contatto.setInstagram(stringhe.get(3));
        contatto.setDescr(stringhe.get(4));
        contatto.setSedeLegale(stringhe.get(5));

        return contatto;
    }
}