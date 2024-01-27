package com.example.webprojectbackend.controller;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
public class RicettaController {


    @GetMapping("/ricetta")
    public String getRicetta(@RequestParam("id") int id, Model model) {
        Ricetta ricetta = DBManager.getInstance().getRicettaDAO().findByPrimaryKey(id);

        String nomeRicetta = ricetta.getNomeRicetta();
        String tag1 = ricetta.getTag1();
        String tag2 = ricetta.getTag2();
        String pathImg = ricetta.getPathImmagine();

        // Passaggio dei valori al frontend tramite il modello
        model.addAttribute("nomeRicetta", nomeRicetta);
        model.addAttribute("tag1", tag1);
        model.addAttribute("tag2", tag2);
        model.addAttribute("pathImg", pathImg);

        // Restituisci il nome della vista da visualizzare, in questo caso, 'ricetta.html'
        return "ricetta";
    }
}
