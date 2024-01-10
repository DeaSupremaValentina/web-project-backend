package com.example.webprojectbackend.persistenza.dao.postgres;

import com.example.webprojectbackend.persistenza.dao.RicettaDAO;
import com.example.webprojectbackend.persistenza.model.Ricetta;

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
        String query = "select * from ricetta";
        try
        {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Ricetta ricetta = new Ricetta();
                ricetta.setCodice(rs.getInt("codice"));
                ricetta.setNomeRicetta(rs.getString("nomericetta"));
                ricetta.setCategoria(rs.getString("categoria"));
                ricetta.setDescrizione(rs.getString("descrizione"));
                ricetta.setIngredienti(rs.getString("ingredienti"));
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
        String query = "select * from ricetta where nomericetta = ?";
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
                ricetta.setIngredienti(rs.getString("ingredienti"));
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
        String query = "select * from ricetta where categoria = ?";
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
                ricetta.setIngredienti(rs.getString("ingredienti"));
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
        String query = "select * from ricetta where tag1 = ? or tag2 = ?";
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
                ricetta.setIngredienti(rs.getString("ingredienti"));
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
        String query = "select * from ricetta where codice = ?";
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
                ricetta.setIngredienti(rs.getString("ingredienti"));
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
        String query = "select * from ricetta where publisher = ?";
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
                ricetta.setIngredienti(rs.getString("ingredienti"));
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
            String query = "insert into ricetta (nomericetta, categoria, descrizione, ingredienti, procedimento, tempi, difficolta, npersone, costo, publisher, immagine, link_spotify, link_youtube, tag1, tag2) values (?,? ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
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
                st.setString(11, recipe.getPathImmagine());
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
        String query = "update ricetta set nomericetta = ?, categoria = ?, descrizione = ?, ingredienti = ?, procedimento = ?, tempi = ?, difficolta = ?, npersone = ?, costo = ?, publisher = ?, immagine = ?, link_spotify = ?, link_youtube = ?, tag1 = ?, tag2 = ? where codice = ?";
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
            st.setString(11, recipe.getPathImmagine());
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
    //veduamo ja
    }

    @Override
    public void delete(Ricetta recipe)
    {
        String query = "delete from ricetta where codice = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, recipe.getCodice());
            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
