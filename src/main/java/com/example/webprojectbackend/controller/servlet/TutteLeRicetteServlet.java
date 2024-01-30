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

@WebServlet("/ricette/tutteLeRicette") //ricette/tutteLeRicette è l'url che si deve inserire nel browser per andare alla pagina html
public class TutteLeRicetteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Ricetta> ricette = DBManager.getInstance().getRicettaDAO().findAll();
        req.setAttribute("lista_ricette", ricette); //parametri: nome della variabile che contiene la lista di ricette per la parte html, lista di ricette

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/TutteLeRicette.html"); //NOTA PARAMETRO DA CAMBIARE
        // parametro: nome della pagina html dove si vuole andare, vedi rigo 81 di questo file

        dispatcher.forward(req, resp); //parametri: richiesta e risposta, questo metodo serve per inviare la richiesta alla pagina html e visualizzarla, resp è la risposta che si ottiene
    }

}

/*
 * The selected code is a Java servlet that handles HTTP GET requests at the URL path "/ricette/tutteLeRicette".
 * This servlet is part of a web application, likely built using Java's Servlet API and possibly part of a larger framework like Java
 * EE (Enterprise Edition) or Spring.

The @WebServlet("/ricette/tutteLeRicette") annotation at the top of the class declaration is used to define the URL pattern for this
* servlet. When a client (like a web browser) makes a GET request to the "/ricette/tutteLeRicette" path on your server, this servlet's
* doGet method will be invoked to handle that request.

Inside the doGet method, it first retrieves a list of Ricetta objects from a database using the
* DBManager.getInstance().getRicettaDAO().findAll() method call. This is likely using the DAO (Data Access Object) pattern, where
* RicettaDAO is a class that encapsulates the logic for retrieving Ricetta objects from the database.

The list of Ricetta objects is then added to the request's attributes under the name "lista_ricette". This allows the data to be
* passed along to the view (the HTML page) that will be displayed to the user.
*
* Il parametro "lista_ricette" è un attributo che stai impostando sulla richiesta HTTP in questo momento. Non è un parametro che viene
* preso da qualche parte, ma piuttosto un nome che stai scegliendo per riferirti a questa lista di oggetti Ricetta che stai passando
* alla vista. Ecco come funziona:
*   Innanzitutto, stai recuperando una lista di oggetti Ricetta dal database. Poi, stai aggiungendo quella lista come un attributo alla
*   richiesta HTTP con il nome "lista_ricette". Questo significa che quando la richiesta viene inoltrata alla vista (la pagina HTML),
*   la vista può accedere a questa lista di oggetti Ricetta utilizzando il nome "lista_ricette".
* In altre parole, stai creando un "ponte" tra il servlet e la vista, permettendo alla vista di accedere ai dati che il servlet ha
* preparato. Il nome "lista_ricette" è il nome di questo ponte. Puoi scegliere qualsiasi nome tu voglia, purché lo usi in modo coerente
* nel servlet e nella vista.

Next, it gets a RequestDispatcher for the "/views/TutteLeRicette.html" view. The RequestDispatcher is used to forward the request
* and response objects to another resource on the server, in this case, an HTML page.

Finally, it calls dispatcher.forward(req, resp) to forward the request and response to the "/views/TutteLeRicette.html" page.
* This will cause the server to send the HTML page back to the client, with access to the "lista_ricette" attribute that was added
* to the request. This attribute can be used in the HTML page to dynamically generate content based on the Ricetta objects retrieved
* from the database.
 
The RequestDispatcher interface in Java Servlets provides the facility of dispatching the request to another resource it may be html,
* servlet or jsp. This interface can also be used to include the content of another resource, which can be useful in template engines
* to include header, footer, or sidebar content.

In the context of the provided code, RequestDispatcher is used to forward the request from the servlet to a specific HTML page
* (/views/TutteLeRicette.html). When the forward method is called on the dispatcher object, the current HTTP request and response
* are forwarded to the specified resource. This allows the servlet to process or prepare data, add it to the request as attributes,
* and then let another resource generate the response. In this case, the HTML page will have access to the Ricetta objects that were
* added to the request, and can use them to dynamically generate content.
*
* il metodo `getRequestDispatcher` prende come parametro il percorso del file a cui vuoi inoltrare la richiesta. Nel tuo caso,
* stai inoltrando la richiesta alla pagina HTML "/views/TutteLeRicette.html". Questo significa che il server cercherà un file chiamato
* "TutteLeRicette.html" nella directory "views" e inoltrerà la richiesta a quel file. Il file HTML avrà quindi accesso a tutti gli
* attributi che hai impostato sulla richiesta, inclusa la lista di ricette che hai salvato con il nome "lista_ricette".

*/
