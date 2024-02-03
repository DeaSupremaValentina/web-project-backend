package com.example.webprojectbackend.controller.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.webprojectbackend.persistenza.dao.postgres.UtentiDAOPostgres;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import com.example.webprojectbackend.persistenza.dao.UtenteDAO;
import com.example.webprojectbackend.persistenza.model.Utente;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;


@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    private UtentiDAOPostgres utenteDAO;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        System.out.println("LoginServlet entrata");

        String userCode = request.getParameter("userCode");
        String tipo = request.getParameter("tipo");
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");

        Utente utente = new Utente(userCode, tipo, email, nome);

        try {
            System.out.println("entrata nel try");
            // Deserializza l'oggetto Utente dalla stringa JSON

            HttpSession session = request.getSession(true);
            session.setAttribute("userId", utente.getUserCode());

            if (utenteDAO.getUtenteByEmail(utente.getEmail()) == null) {
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
