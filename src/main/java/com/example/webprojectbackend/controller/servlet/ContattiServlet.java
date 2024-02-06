package com.example.webprojectbackend.controller.servlet;

import java.io.IOException;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Contatto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contatti")
public class ContattiServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contatto contatto = DBManager.getInstance().getContattoDAO().geContatto();
        req.setAttribute("descr", contatto.getDescr());
        req.setAttribute("email", contatto.getEmail());
        req.setAttribute("spotify", contatto.getSpotify());
        req.setAttribute("telefono", contatto.getTelefono());
        req.setAttribute("sedeLegale", contatto.getSedeLegale());
        req.getRequestDispatcher("chi_siamo.html").forward(req, resp);;
    }
}