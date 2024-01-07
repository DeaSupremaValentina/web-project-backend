package com.example.webprojectbackend.persistenza;

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
}
