package com.example.webprojectbackend.persistenza;

import com.example.webprojectbackend.persistenza.dao.CommentoDAO;
import com.example.webprojectbackend.persistenza.dao.RicettaDAO;
import com.example.webprojectbackend.persistenza.dao.UtenteDAO;
import com.example.webprojectbackend.persistenza.dao.ValutazioneDAO;
import com.example.webprojectbackend.persistenza.dao.postgres.CommentiDAOPostgres;
import com.example.webprojectbackend.persistenza.dao.postgres.RicetteDAOPostgres;
import com.example.webprojectbackend.persistenza.dao.postgres.UtentiDAOPostgres;
import com.example.webprojectbackend.persistenza.dao.postgres.ValutazioniDAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager
{
    private static DBManager instance = null;
    private DBManager(){}

    public static DBManager getInstance()
    {
        if (instance == null)
            {   instance = new DBManager(); }
        return instance;
    }

    Connection connection = null;

    public Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            }
            catch (SQLException e)
            { throw new RuntimeException(e); }
        }
        return connection;
    }

    //aggiunta Dao
    public RicettaDAO getRicettaDAO()
    {
        return new RicetteDAOPostgres(getConnection());
    }

    public CommentoDAO getCommentoDAO()
    {
        return new CommentiDAOPostgres(getConnection());
    }

    public ValutazioneDAO getValutazioneDAO()
    {
        return new ValutazioniDAOPostgres(getConnection());
    }

    public UtenteDAO getUtenteDAO()
    {
        return new UtentiDAOPostgres(getConnection());
    }

}
