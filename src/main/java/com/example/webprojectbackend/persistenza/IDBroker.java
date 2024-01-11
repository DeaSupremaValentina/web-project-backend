package com.example.webprojectbackend.persistenza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class IDBroker {

    public static int getRicetteId(Connection connection) {
        //tabella per le ricette
        String query = "SELECT nextval('ricette_seq') AS id";
        return Math.toIntExact(getId(connection, query));
    }

    public static int getValutazioniId(Connection connection) {
        //tabella per le valutazioni
        String query = "SELECT nextval('valutazioni_seq') AS id";
        return Math.toIntExact(getId(connection, query));
    }

    public static int getCommentiId(Connection connection) {
        //tabella per i commenti
        String query = "SELECT nextval('commenti_seq') AS id";
        return Math.toIntExact(getId(connection, query));
    }

    private static Long getId(Connection connection, String query) {
        Long id = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            result.next();
            id = result.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}