package com.example.webprojectbackend.controller.servlet;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.IDBroker;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;

//questa servlet gestisce la proposta di una ricetta da parte di un utente
@WebServlet("/PropostaRicetta")
public class PropostaRicetteServlet extends HttpServlet {
    //Connection conn = DBManager.getInstance().getConnection();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        /*String nomeRicetta = req.getParameter("nomeRicetta");
        String categoria = req.getParameter("categoria");
        String descrizione = req.getParameter("descrizione");
        String ingredienti = req.getParameter("ingredienti");
        String procedimento = req.getParameter("procedimento");
        String tempoPreparazione = req.getParameter("tempoPreparazione");
        String numeroPersone = req.getParameter("numeroPersone");
        String difficolta = req.getParameter("difficolta");
        String costo = req.getParameter("costo");
        String linkYoutube = req.getParameter("linkYoutube");
        String linkSpotify = req.getParameter("linkSpotify");
        String pathImmagine = req.getParameter("pathImmagine");
        String autore = req.getParameter("autore");
        String tag1 = req.getParameter("tag1");
        String tag2 = req.getParameter("tag2");

        if (nomeRicetta == null || categoria == null || descrizione == null || ingredienti == null || procedimento == null || tempoPreparazione == null || numeroPersone == null || difficolta == null || costo == null || pathImmagine == null || autore == null || tag1 == null || tag2 == null)
            throw new IllegalArgumentException("Tutti i campi devono essere riempiti");

        if (linkYoutube == null)
            linkYoutube = "";
        if (linkSpotify == null)
            linkSpotify = "";
    
        int codice = IDBroker.getRicetteId(conn);
        Ricetta ricetta = new Ricetta(codice, nomeRicetta, categoria, descrizione, ingredienti, procedimento, tempoPreparazione, numeroPersone, difficolta, costo, linkYoutube, linkSpotify, pathImmagine, autore, tag1, tag2);
        DBManager.getInstance().getRicettaDAO().newProposal(ricetta);

        */
    }
}


/*
 * The selected code is a Java servlet that handles HTTP POST requests at the URL path "/PropostaRicetta". This servlet is part of a web application, likely built using 
 * Java's Servlet API and Maven for dependency management.

The `@WebServlet("/PropostaRicetta")` annotation at the top of the class declaration is used to define the URL pattern for this servlet. When a client (like a web browser)
 makes a POST request to the "/PropostaRicetta" path on your server, this servlet's `doPost` method will be invoked to handle that request.

Inside the `doPost` method, it first retrieves a series of parameters from the HTTP request. These parameters are likely sent by the client as part of the request body, 
and they represent different attributes of a `Ricetta` (Recipe) object, such as its name, category, description, ingredients, preparation time, number of people it serves,
difficulty, cost, YouTube link, Spotify link, image path, author, and two tags.

Next, it generates a unique ID for the new `Ricetta` using the `IDBroker.getRicetteId(conn)` method. This ID is used to create a new `Ricetta` object with all the 
attributes retrieved from the request.

Finally, it calls `DBManager.getInstance().getRicettaDAO().newProposal(ricetta)` to save the new `Ricetta` object to the database. This is likely using the DAO 
(Data Access Object) pattern, where `RicettaDAO` is a class that encapsulates the logic for saving `Ricetta` objects to the database.

In summary, this servlet is responsible for handling requests to create new `Ricetta` objects and save them to the database. The client sends the data for the new 
`Ricetta` as parameters in a POST request, and the servlet retrieves this data, creates a new `Ricetta` object, and saves it to the database.
 */
