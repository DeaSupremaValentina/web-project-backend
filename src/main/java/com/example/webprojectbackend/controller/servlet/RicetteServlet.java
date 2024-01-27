package com.example.webprojectbackend.controller.servlet;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


//servlet che gestisce la pagina delle ricette, mostra tutte le ricette
@WebServlet("/TutteLeRicette") //Url: http://localhost:8080/TutteLeRicette
public class RicetteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {
        List<Ricetta> ricette =
                DBManager.getInstance().getRicettaDAO().findAll();  //la query restituisce una lista di ricette
        for (Ricetta r : ricette){
            System.out.println(r.getNomeRicetta()); //stampa il nome di ogni ricetta
        }
        req.setAttribute("lista_ricette", ricette); //passa la lista di ricette alla pagina delle ricette
        // lista_ricette è il nome della variabile che contiene la lista di ricette, si può cambiare, mentre ricette è la lista di ricette

        RequestDispatcher dispatcher = req.getRequestDispatcher("/ricette.html"); //pagina delle ricette
        dispatcher.forward(req, resp);
        //resp.getWriter().println("<h1>Funziona</h1>");
    }
}