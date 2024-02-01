package com.example.webprojectbackend.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.example.webprojectbackend.persistenza.model.Utente;

import com.google.gson.Gson;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Ottieni i dati dell'utente dalla richiesta
        String idToken = request.getParameter("idToken");
        String utenteJson = request.getParameter("utente");

        try {
            // Deserializza l'oggetto Utente dalla stringa JSON
            Gson gson = new Gson();
            Utente utente = gson.fromJson(utenteJson, Utente.class);

            // Simula la creazione di una sessione (puoi personalizzare questa parte)
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", utente.getUserCode());

            // Puoi aggiungere qui la logica di autenticazione, ad esempio verificando le credenziali utente,
            // interagendo con un database per verificare l'utente, ecc.

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