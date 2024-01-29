package com.example.webprojectbackend.controller.servlet;
import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.dao.RicettaDAO;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/*
2. Servlet per la Ricerca e la Visualizzazione delle Ricette:*

        - Implementa una servlet per gestire la ricerca di ricette e la visualizzazione dei dettagli.
        - Puoi avere endpoint specifici per ottenere tutte le ricette, ricette per categoria, ecc.
*/

@WebServlet("/ricette/tutteLeRicette")
public class TutteLeRicetteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Ricetta> ricette = DBManager.getInstance().getRicettaDAO().findAll();
        req.setAttribute("lista_ricette", ricette); //parametri: nome della variabile che contiene la lista di ricette per la parte html, lista di ricette

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/TutteLeRicette.html"); // parametro: nome della pagina html dove si vuole andare
        //il dispatcher serve per andare alla pagina html
        dispatcher.forward(req, resp); //parametri: richiesta e risposta, questo metodo serve per inviare la richiesta alla pagina html e visualizzarla, resp è la risposta che si ottiene
    }

}
