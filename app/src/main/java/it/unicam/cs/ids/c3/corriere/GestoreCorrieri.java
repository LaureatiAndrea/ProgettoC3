package it.unicam.cs.ids.c3.corriere;

import it.unicam.cs.ids.c3.database.MySqlDatabase;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire i corrieri registrati nel sistema C3.
 * Mette a disposizione metodi per accedere, modificare, rimuovere clienti.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreCorrieri {

    private ArrayList<Corriere> corrieri;
    private MySqlDatabase db;
    private static GestoreCorrieri instance;
    private Corriere loggedInUser;

    /**
     * Metodo per ottenere l'istanza del GestoreCorrieri ( La classe é implementata come Singleton ).
     * @return l'istanza del GestoreCorrieri, creandola se non esiste giá.
     */
    public static GestoreCorrieri getInstance(){
        if(instance==null){
            instance = new GestoreCorrieri();
        }
        return instance;
    }

    public GestoreCorrieri(){
        db = MySqlDatabase.getInstance();
        corrieri = db.getAllCorrieri();
    }

    /**
     * Aggiunge un corriere alla lista dei corrieri.
     * @param c il corriere da aggiungere.
     */
    public void addCorriere(Corriere c){
        //TODO : Implementare interazione con il db.
        corrieri.add(c);
    }

    /**
     * Rimuove un corriere dalla lista dei corrieri.
     * @param c il corriere da rimuovere.
     */
    public void removeCliente(Corriere c){
        //TODO : Implementare interazione con il db.
        corrieri.remove(c);
    }

    /**
     * Ricerca uno specifico corriere all'interno della lista. La ricerca avviene usando l'identificativo.
     * @param id l'identificativo del corriere che si vuole ricercare.
     * @return il corriere se é presente, null altrimenti.
     */
    public Corriere getCorriere(int id){
        for(Corriere c : corrieri){
            if (c.getId() == id )
                return c;
        }
        return null;
    }

    /**
     * Restituisce la lista di tutti i corrieri registrati al sistema C3.
     * @return la lista dei corrieri registrati.
     */
    public ArrayList<Corriere> getCorrieri(){
        return this.corrieri;
    }

    /**
     * Restituisce la lista dei corrieri disponibili ad effettuare trasporti.
     * @return la lista dei corrieri disponibili.
     */
    public ArrayList<Corriere> getCorrieriDisponibili(){
        ArrayList<Corriere> toReturn = new ArrayList<>();
        for(Corriere c : corrieri){
            if (c.getStato()==Stato_Corriere.DISPONIBILE){
                toReturn.add(c);
            }
        }
        return toReturn;
    }

    /**
     * Modifica lo stato di disponibilita di un determinato corriere presente all'interno del gestore
     * @param idCorriere l'id del corriere di cui si vuole modificare la disponibilita
     * @param statoCorriere il nuovo stato di disponibilita del corriere
     */
    public void setStatoCorriere(int idCorriere, Stato_Corriere statoCorriere) {
        db.setStatoCorriere(idCorriere,statoCorriere);
        corrieri = db.getAllCorrieri();
    }

    /**
     * Setta il corriere attualmente loggato nel sistema C3.
     * @param corriere il corriere loggato.
     */
    public void setLoggedInUser(Corriere corriere) {
        this.loggedInUser = corriere;
    }

    /**
     * Restituisce il corriere attualmente loggato nel sistema C3.
     * @return il corriere loggato
     */
    public Corriere getLoggedInUser(){
        return this.loggedInUser;
    }
}
