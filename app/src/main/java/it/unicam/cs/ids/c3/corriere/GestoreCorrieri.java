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
        //La lista viene recuperata direttamente dal database
        db = MySqlDatabase.getInstance();
        corrieri = db.getAllCorrieri();
    }

    /**
     * Aggiunge un corriere alla lista dei corrieri.
     * @param c il corriere da aggiungere.
     */
    public void addCorriere(Corriere c){
        //TODO : Adattare al database
        corrieri.add(c);
    }

    /**
     * Rimuove un corriere dalla lista dei corrieri.
     * @param c il corriere da rimuovere.
     */
    public void removeCliente(Corriere c){
        //TODO : Adattare al database
        corrieri.remove(c);
    }

    /**
     * Ricerca uno specifico corriere all'interno della lista. La ricerca avviene usando l'identificativo.
     * @param id l'identificativo del corriere che si vuole ricercare.
     * @return il corriere se é presente, null altrimenti.
     */
    public Corriere getCorriere(int id){
        //TODO : Considerare se adattare al database
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
        //TODO : Considerare se adattare al database
        return this.corrieri;
    }

    /**
     * Restituisce la lista dei corrieri disponibili ad effettuare trasporti.
     * @return la lista dei corrieri disponibili.
     */
    public ArrayList<Corriere> getCorrieriDisponibili(){
        //TODO : Considerare se adattare al database
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
}
