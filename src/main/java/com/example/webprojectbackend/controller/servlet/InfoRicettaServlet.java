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


//servlet che gestisce la pagina delle ricette, mostra tutte le info della ricetta selezionata tramite id
@WebServlet("/InfoRicetta") //Url: http://localhost:8080/InfoRicetta
public class InfoRicettaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {
      Ricetta ricetta = DBManager.getInstance().getRicettaDAO().findByPrimaryKey(Integer.parseInt(req.getParameter("id"))); //ricetta specifica trovata tramite Id
        req.setAttribute("ricetta", ricetta);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/ricetta.html"); //pagina della ricetta
        dispatcher.forward(req, resp);

    }
}
/*

 * The selected code is a Java servlet that handles HTTP GET requests at the URL path "/InfoRicetta". This servlet is part of a web application,
 * likely built using Java's Servlet API and Maven for dependency management.


 * The `@WebServlet("/InfoRicetta")` annotation at the top of the class declaration is used to define the URL pattern for this servlet. 
 * When a client (like a web browser) makes a GET request to the "/InfoRicetta" path on your server, this servlet's `doGet` method will be 
 * invoked to handle that request.
 * Inside the `doGet` method, it first retrieves a `Ricetta` object from a database using the `DBManager.getInstance().getRicettaDAO().findByPrimaryKey(Integer.parseInt(req.getParameter("id")))` 
 * method call. This is likely using the DAO (Data Access Object) pattern, where `RicettaDAO` is a class that encapsulates the logic for 
 * retrieving `Ricetta` objects from the database. The `findByPrimaryKey` method is used to retrieve a single `Ricetta` object that matches the 
 * provided primary key, which in this case is obtained from the "id" parameter of the HTTP request.


 * The `Ricetta` object is then added to the request's attributes under the name "ricetta". This allows the data to be passed along to the view 
 * (the HTML page) that will be displayed to the user.

 * Next, it gets a `RequestDispatcher` for the "/ricetta.html" view. The `RequestDispatcher` is used to forward the request and response objects
 * to another resource on the server, in this case, an HTML page.

 * Finally, it calls `dispatcher.forward(req, resp)` to forward the request and response to the "/ricetta.html" page. This will cause the server 
 * to send the HTML page back to the client, with access to the "ricetta" attribute that was added to the request. This attribute can be used in
 * the HTML page to dynamically generate content based on the `Ricetta` object retrieved from the database.
 
 
*/

