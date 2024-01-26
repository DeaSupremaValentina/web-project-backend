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

@WebServlet("/TutteLeRicette") //Url: http://localhost:8080/TutteLeRicette
public class RicetteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {
        List<Ricetta> ricette =
                DBManager.getInstance().getRicettaDAO().findAll();
        for (Ricetta r : ricette){
            System.out.println(r.getNomeRicetta());
        }
        req.setAttribute("lista_ricette", ricette);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ricette.html");
        dispatcher.forward(req, resp);
        //resp.getWriter().println("<h1>Funziona</h1>");
    }
}