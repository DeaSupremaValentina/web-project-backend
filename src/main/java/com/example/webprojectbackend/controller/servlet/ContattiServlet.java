package com.example.webprojectbackend.controller.servlet;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Contatto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/chi_siamo")
public class ContattiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contatto contatto = DBManager.getInstance().getContattoDAO().findAll();
        req.setAttribute("contatto", contatto);
        req.getRequestDispatcher("/chi-siamo.component.html").forward(req, resp);
        
    }

}
/*
 * 1. La servlet ContattiServlet è mappata all'indirizzo "/chi_siamo" tramite l'annotazione @WebServlet("/chi_siamo").
 * 2. La servlet estende HttpServlet e ridefinisce il metodo doGet.
 * 3. Nel metodo doGet, la servlet recupera il contatto tramite il metodo findAll del ContattoDAO e lo inserisce nell'attributo "contatto" della richiesta.
 * 4. Infine, la servlet inoltra la richiesta alla pagina "chi-siamo.component.html". Questa pagina è una pagina statica che contiene il codice HTML 
 *  e Angular per visualizzare i contatti. 
 * 
 * 
 * 
The selected code is a Java servlet that handles HTTP GET requests at the URL path "/chi_siamo". This servlet is part of a web application, likely built using Java's Servlet API and Maven for dependency management.

The `@WebServlet("/chi_siamo")` annotation at the top of the class declaration is used to define the URL pattern for this servlet. When a client (like a web browser) makes a GET request to the "/chi_siamo" path on your server, this servlet's `doGet` method will be invoked to handle that request.

Inside the `doGet` method, it first retrieves a `Contatto` object from a database using the `DBManager.getInstance().getContattoDAO().findAll()` method call. This is likely using the DAO (Data Access Object) pattern, where `ContattoDAO` is a class that encapsulates the logic for retrieving `Contatto` objects from the database. The `findAll` method is used to retrieve all `Contatto` objects from the database.

The `Contatto` object is then added to the request's attributes under the name "contatto". This allows the data to be passed along to the view (the HTML page) that will be displayed to the user.

Next, it gets a `RequestDispatcher` for the "/chi-siamo.component.html" view. The `RequestDispatcher` is used to forward the request and response objects to another resource on the server, in this case, an HTML page.

Finally, it calls `dispatcher.forward(req, resp)` to forward the request and response to the "/chi-siamo.component.html" page. This will cause the server to send the HTML page back to the client, with access to the "contatto" attribute that was added to the request. This attribute can be used in the HTML page to dynamically generate content based on the `Contatto` object retrieved from the database.
 */
