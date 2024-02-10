package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.DBManager;
import com.example.webprojectbackend.persistenza.ImageConverter;
import com.example.webprojectbackend.persistenza.dao.RicettaDAO;
import com.example.webprojectbackend.persistenza.model.Commento;
import com.example.webprojectbackend.persistenza.model.Ricetta;
import com.example.webprojectbackend.persistenza.model.Utente;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class RicetteDAOPostgres implements RicettaDAO
{

    Connection conn;

    public RicetteDAOPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Ricetta> findAll() {
        List<Ricetta> ricette = new ArrayList<Ricetta>();
        String query = "select * from ricette";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Ricetta ricetta = new Ricetta();
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                System.out.println(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ricette;
    }

    @Override
    public List<Ricetta> findByNome(String nome) {
        Ricetta ricetta = null;
        List<Ricetta> ricette = new ArrayList<Ricetta>();
        String query = "select * from ricette where nomericetta = ?";
        System.out.println(nome);
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nome);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ricetta = new Ricetta();
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ricette;
    }

    @Override
    public List<Ricetta> findByCategoria(String categoria) {
        Ricetta ricetta = null;
        List<Ricetta> ricette = new ArrayList<Ricetta>();
        String query = "select * from ricette where categoria = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, categoria);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ricetta = new Ricetta();
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ricette;
    }

    @Override
    public List<Ricetta> findByTag(String tag) {
        Ricetta ricetta = null;
        List<Ricetta> ricette = new ArrayList<Ricetta>();
        String query = "select * from ricette where tag1 = ? or tag2 = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, tag);
            st.setString(2, tag);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ricetta = new Ricetta();
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ricette;


    }

    @Override
    public Ricetta findByPrimaryKey(int id) {
        Ricetta ricetta = null;
        String query = "select * from ricette where codice = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                ricetta = new Ricetta();
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                List<Commento> commenti = DBManager.getInstance().getCommentoDAO().findByCodiceRicetta(rs.getInt("codice"));
                for(int i=0; i<commenti.size(); i++)
                {
                    System.out.println(commenti.get(i).getContenuto());
                }
                ricetta.setCommenti(commenti);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ricetta;
    }

    @Override
    public List<Ricetta> findByUsername(String username) {
        Ricetta ricetta = null;
        List<Ricetta> ricette = new ArrayList<Ricetta>();
        String query = "select * from ricette where publisher = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ricetta = new Ricetta();
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ricette;
    }

    @Override
    public void save(Ricetta recipe) {
            String query = "insert into ricette (nomericetta, categoria, descrizione, listaingredienti, procedimento, tempi, difficolta, npersone, costo, publisher, immagine, link_spotify, link_youtube, tag1, tag2) values (?,? ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, recipe.getNomeRicetta());
                st.setString(2, recipe.getCategoria());
                st.setString(3, recipe.getDescrizione());
                st.setString(4, recipe.getIngredienti());
                st.setString(5, recipe.getProcedimento());
                st.setString(6, recipe.getTempoPreparazione());
                st.setString(7, recipe.getDifficolta());
                st.setString(8, recipe.getNumeroPersone());
                st.setString(9, recipe.getCosto());
                st.setString(10, recipe.getAutore());
                // st.setString(11, recipe.getPathImmagine());
                String imgBase64 = ImageConverter.getInstance().convertToData(recipe.getPathImmagine());
                st.setString(11, imgBase64);
                st.setString(12, recipe.getLinkSpotify());
                st.setString(13, recipe.getLinkYoutube());
                st.setString(14, recipe.getTag1());
                st.setString(15, recipe.getTag2());
                st.executeUpdate();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public boolean update(Ricetta recipe) {
        String query = "update ricette set nomericetta = ?, categoria = ?, descrizione = ?, listaingredienti = ?, procedimento = ?, tempi = ?, difficolta = ?, npersone = ?, costo = ?, publisher = ?, immagine = ?, link_spotify = ?, link_youtube = ?, tag1 = ?, tag2 = ? where codice = ?";
        int t = -666; //numero casuale per settare t ad un valore che non causi sviste
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, recipe.getNomeRicetta());
            st.setString(2, recipe.getCategoria());
            st.setString(3, recipe.getDescrizione());
            st.setString(4, recipe.getIngredienti());
            st.setString(5, recipe.getProcedimento());
            st.setString(6, recipe.getTempoPreparazione());
            st.setString(7, recipe.getDifficolta());
            st.setString(8, recipe.getNumeroPersone());
            st.setString(9, recipe.getCosto());
            st.setString(10, recipe.getAutore());
            // st.setString(11, recipe.getPathImmagine());
            String imgBase64 = ImageConverter.getInstance().convertToData(recipe.getPathImmagine());
            st.setString(11, imgBase64);
            st.setString(12, recipe.getLinkSpotify());
            st.setString(13, recipe.getLinkYoutube());
            st.setString(14, recipe.getTag1());
            st.setString(15, recipe.getTag2());
            st.setInt(16, recipe.getCodice());
            t = st.executeUpdate();
            if (t == 1)
                return true;


        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public void newProposal(Ricetta recipe) {
        String query = "insert into daapprovare (nomericetta, categoria, linkyoutube, linkspotify, listaingredienti, descrizione, npersone, tempi, tag1, tag2, immagine, procedimento, publisher, difficolta, costo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            System.out.println("sono nella query per proposta" + recipe.getNomeRicetta() +"\n");
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, recipe.getNomeRicetta());
            st.setString(2, recipe.getCategoria());
            st.setString(3, recipe.getLinkYoutube());
            st.setString(4, recipe.getLinkSpotify());
            st.setString(5, recipe.getIngredienti());
            st.setString(6, recipe.getDescrizione());
            st.setString(7, recipe.getNumeroPersone());
            st.setString(8, recipe.getTempoPreparazione());
            st.setString(9, recipe.getTag1());
            st.setString(10, recipe.getTag2());
            st.setString(11, recipe.getPathImmagine());
            st.setString(12, recipe.getProcedimento());
            st.setString(13, recipe.getAutore());
            st.setString(14, recipe.getDifficolta());
            st.setString(15, recipe.getCosto());



            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProposal(Ricetta recipe) {
        String query = "delete from daapprovare where codice = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, recipe.getCodice());
            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Ricetta> findAllProposals() {
        List<Ricetta> ricette = new ArrayList<Ricetta>();
        String query = "select * from daapprovare";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Ricetta ricetta = new Ricetta();
                //ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("linkspotify"));
                ricetta.setLinkYoutube(rs.getString("linkyoutube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ricette;
    }

    @Override
    public void delete(Ricetta recipe)
    {
        String query = "delete from ricette where codice = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, recipe.getCodice());
            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveNewRecipe(int codiceRicetta, Utente utente) //query per salvare una nuova ricetta
    {
        String query = "insert into ricettesalvate (ricetta, utente) values (?,?)";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, codiceRicetta);
            st.setString(2, utente.getUserCode());
            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void unsaveRecipe(int codiceRicetta, Utente utente) //query per eliminare una ricetta salvata
    {
        String query = "delete from ricettesalvate where ricetta = ? and utente = ?";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, codiceRicetta);
            st.setString(2, utente.getUserCode());
            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Ricetta> findSavedRecipes (Utente user) {
        List<Ricetta> ricette = new ArrayList<>();
        String query = "SELECT * FROM ricettesalvate INNER JOIN ricette ON ricette.codice=ricettesalvate.ricetta WHERE utente = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, user.getUserCode());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Ricetta ricetta = new RicetteProxy(conn);
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ricette;
    }


    public List<Ricetta> findAllLazy() {
        List<Ricetta> ricette = new ArrayList<Ricetta>();
        try
        {
            System.out.println("in allLazy");
            String query = "SELECT * FROM ricette";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Ricetta ricetta = new RicetteProxy(conn);
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ricette;
        }


    public List<Ricetta> genericSearch(String cercata)
    {
        List<Ricetta> ricette = new ArrayList<Ricetta>();
        String query = "SELECT * FROM ricette WHERE nomericetta LIKE ? OR categoria LIKE ? OR tag1 LIKE ? OR tag2 LIKE ?";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, cercata);
            st.setString(2, cercata);
            st.setString(3, cercata);
            st.setString(4, cercata);

            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Ricetta ricetta = new Ricetta();
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("listaingredienti"));
                ricetta.setProcedimento(rs.getString("procedimento"));
                ricetta.setTempoPreparazione(rs.getString("tempi"));
                ricetta.setDifficolta(rs.getString("difficolta"));
                ricetta.setNumeroPersone(rs.getString("npersone"));
                ricetta.setCosto(rs.getString("costo"));
                ricetta.setAutore(rs.getString("publisher"));
                ricetta.setPathImmagine(rs.getString("immagine"));
                ricetta.setLinkSpotify(rs.getString("link_spotify"));
                ricetta.setLinkYoutube(rs.getString("link_youtube"));
                ricetta.setTag1(rs.getString("tag1"));
                ricetta.setTag2(rs.getString("tag2"));
                ricette.add(ricetta);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ricette;
    }
}
