package com.example.webprojectbackend.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.example.webprojectbackend.persistenza.dao.UtenteDAO;
import com.example.webprojectbackend.persistenza.model.Utente;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    @Autowired
    private UtenteDAO utenteDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Ottieni i dati dell'utente dalla richiesta
        String utenteJson = request.getParameter("utente");

        try {
            // Deserializza l'oggetto Utente dalla stringa JSON
            Gson gson = new Gson();
            Utente utente = gson.fromJson(utenteJson, Utente.class);


            HttpSession session = request.getSession(true);
            session.setAttribute("userId", utente.getUserCode());


            if(utenteDAO.getUtenteByEmail(utente.getEmail()) == null){
                utenteDAO.save(utente);
            }

            // Invia una risposta di successo al client
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            out.println("Login successo");
        } catch (Exception e) {
            // Se si verifica un errore, invia una risposta di errore al client
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter out = response.getWriter();
            out.println("Login fallito");
            e.printStackTrace();
        }
    }
}