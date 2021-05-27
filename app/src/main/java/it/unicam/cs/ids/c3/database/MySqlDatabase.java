package it.unicam.cs.ids.c3.database;

import it.unicam.cs.ids.c3.cliente.Cliente;
import it.unicam.cs.ids.c3.cliente.SimpleCliente;
import it.unicam.cs.ids.c3.corriere.Corriere;
import it.unicam.cs.ids.c3.corriere.SimpleCorriere;
import it.unicam.cs.ids.c3.corriere.Stato_Corriere;
import it.unicam.cs.ids.c3.magazzino.Magazzino;
import it.unicam.cs.ids.c3.magazzino.SimpleMagazzino;
import it.unicam.cs.ids.c3.negozio.Categoria_Merceologica;
import it.unicam.cs.ids.c3.negozio.Negozio;
import it.unicam.cs.ids.c3.negozio.Promozione;
import it.unicam.cs.ids.c3.negozio.SimpleNegozio;
import it.unicam.cs.ids.c3.ordine.Ordine;
import it.unicam.cs.ids.c3.ordine.SimpleOrdine;
import it.unicam.cs.ids.c3.ordine.Stato_Ordine;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.util.ArrayList;

/**
 * La classe si occupa della connessione al database MySql
 *
 * @author Laureati Andrea Francesco, Gaetani Marco
 */
public class MySqlDatabase {
    private static MySqlDatabase instance;
    private Connection connection;
    private ResultSet resultset;

    /**
     * Costruttore : Effettua la connessione al database.
     */
    private MySqlDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c3?"
                    + "user=root&password=root");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /**
     * La classe MySqlDatabase viene implementata come un Singleton
     * @return un istanza della connessione al database
     */
    public static MySqlDatabase getInstance(){
        if(instance == null){
            instance = new MySqlDatabase();
        }
        return instance;
    }

    /**
     * Questo metodo si occupa di eseguire interrogazioni sul database
     * @param query     la query SQL da eseguire
     * @return          il resultset contenente il risultato della query
     */
    public ResultSet query(String query){
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(query);
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return this.resultset;
    }

    /**
     * Metodo getter per la connessione al database
     */
    public Connection getConnection(){
        return this.connection;
    }

    public ArrayList<Cliente> getAllClienti() {
        ArrayList<Cliente> toReturn = new ArrayList<>();
        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM clienti");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                toReturn.add(new SimpleCliente(rs.getInt("id"),rs.getString("nome"),rs.getString("cognome"),rs.getString("indirizzo")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toReturn;
    }

    /**
     * Restituisce la lista dei magazzini presenti sul DB
     * @return la lista dei magazzini
     */
    public ArrayList<Magazzino> getAllMagazzini() {
        ArrayList<Magazzino> toReturn = new ArrayList<>();
        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM magazzini");
            ResultSet rs = query.executeQuery();
            //Salta il magazzino con indice -1
            rs.next();
            while(rs.next()){
                toReturn.add(new SimpleMagazzino(rs.getInt("id"),rs.getString("nome"),rs.getString("indirizzo")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toReturn;
    }

    /**
     * Restituisce la lista dei corrieri presenti sul DB
     * @return la lista dei corrieri
     */
    public ArrayList<Corriere> getAllCorrieri() {
        ArrayList<Corriere> toReturn = new ArrayList<>();
        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM corrieri");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                toReturn.add(new SimpleCorriere(rs.getInt("id"),rs.getString("nome"),
                        rs.getString("cognome"), Stato_Corriere.valueOf(rs.getString("stato"))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toReturn;
    }

    /**
     * Restituisce la lista degli ordini presenti sul DB
     * @return la lista degli ordini
     */
    public ArrayList<Ordine> getAllOrdini() {
        ArrayList<Ordine> toReturn = new ArrayList<>();
        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM ordini");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                toReturn.add(new SimpleOrdine(rs.getInt("id"),
                        rs.getInt("idCliente"),
                        rs.getString("destinazione"),
                        rs.getString("note"),
                        rs.getInt("idMagazzino"),
                        rs.getInt("idNegozio"),
                        rs.getInt("codiceRitiro"),
                        rs.getInt("idCorriere"),
                        rs.getString("statoOrdine")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toReturn;
    }

    /**
     * Effettua la INSERT di un nuovo ordine sul DB
     * @param toAdd l'ordine da inserire
     */
    public void addOrdine(Ordine toAdd) {
        try {
            PreparedStatement query = connection.
                    prepareStatement("INSERT INTO ordini(id, destinazione, note, statoOrdine, idCliente, idNegozio," +
                            "idCorriere, idMagazzino, codiceRitiro) " +
                            "VALUES (?,?,?,?,?,?,?,?,?)");
            query.setInt(1, toAdd.getID());
            query.setString(2, toAdd.getDestinazione());
            query.setString(3, toAdd.getNote());
            query.setString(4, toAdd.getStatoOrdine().name());
            query.setInt(5, toAdd.getIdCliente());
            query.setInt(6, toAdd.getIdNegozio());
            query.setInt(7, toAdd.getIdCorriere());
            query.setInt(8, toAdd.getIdMagazzino());
            query.setInt(9, toAdd.getCodiceRitiro());

            int result = query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Restituisce tutti i negozi presenti sul DB
     * @return la lista dei negozi
     */
    public ArrayList<Negozio> getAllNegozi() {
        ArrayList<Negozio> toReturn = new ArrayList<>();
        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM negozi");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                //Per ogni negozio, deve recuperare anche le promozioni
                query = connection.prepareStatement("SELECT * FROM promozioni WHERE negozioId = ?");
                query.setInt(1,rs.getInt("id"));
                ResultSet rs2 = query.executeQuery();
                ArrayList<Promozione> promozioniToAdd = new ArrayList<Promozione>();
                while(rs2.next()){
                    promozioniToAdd.add(new Promozione(rs2.getInt("id"),
                            rs2.getDouble("percentualeSconto"),rs2.getInt("promozioneAttiva")));
                }
                toReturn.add(new SimpleNegozio(rs.getInt("id"),rs.getString("nome"),
                        rs.getString("indirizzo"),
                        Categoria_Merceologica.valueOf(rs.getString("categoria")), rs.getInt("idImpiegato"),promozioniToAdd));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toReturn;
    }

    /**
     * Modifica lo stato di un particolare ordine presente sul DB
     * @param idOrdine l'id dell'ordine da modificare
     * @param stato lo stato dell'ordine
     */
    public void setStatoOrdine(int idOrdine, String stato) {
        try {
            PreparedStatement query = connection.
                    prepareStatement("UPDATE c3.ordini SET statoOrdine = ? WHERE id = ?");
            query.setString(1, stato);
            query.setInt(2,idOrdine);
            int result = query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Modifica la disponibilitá di un corriere presente sul DB
     * @param idCorriere l'id del corriere da modificare
     * @param statoCorriere il nuovo stato del corriere
     */
    public void setStatoCorriere(int idCorriere, Stato_Corriere statoCorriere) {
        try {
            PreparedStatement query = connection.
                    prepareStatement("UPDATE c3.corrieri SET stato = ? WHERE id = ?");
            query.setString(1, statoCorriere.name());
            query.setInt(2,idCorriere);
            int result = query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
