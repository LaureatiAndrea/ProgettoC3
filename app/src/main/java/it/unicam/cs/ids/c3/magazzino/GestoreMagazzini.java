package it.unicam.cs.ids.c3.magazzino;

import it.unicam.cs.ids.c3.database.MySqlDatabase;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire i magazzini disponibili nel sistema C3.
 * Mette a disposizioni metodi per accedere, modificare e rimuovere magazzini.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreMagazzini {

    private ArrayList<Magazzino> magazzini;
    MySqlDatabase db;
    private static GestoreMagazzini instance;

    /**
     * Metodo per ottenere l'istanza del GestoreMagazzini ( La classe é implementata come Singleton ).
     * @return l'istanza del GestoreMagazzini, creandola se non esiste giá.
     */
    public static GestoreMagazzini getInstance(){
        if(instance == null){
            instance = new GestoreMagazzini();
        }
        return instance;
    }

    public GestoreMagazzini(){
        db = MySqlDatabase.getInstance();
        this.magazzini = db.getAllMagazzini();
    }

    /**
     * Aggiunge un magazzino alla lista dei clienti.
     * @param m il magazzino da aggiungere.
     */
    public void addMagazzino(Magazzino m){
        //TODO : Implementare interazione con il db.
        magazzini.add(m);
    }

    /**
     * Rimuove un magazzino dalla lista dei magazzini.
     * @param m il magazzino da rimuovere.
     */
    public void removeMagazzino(Magazzino m){
        //TODO : Implementare interazione con il db.
        magazzini.remove(m);
    }

    /**
     * Restituisce la lista di tutti i magazzini disponibili nel sistema C3.
     * @return la lista dei magazzini registrati.
     */
    public ArrayList<Magazzino> getMagazzini(){
        return this.magazzini;
    }

    /**
     * Ricerca uno specifico magazzino all'interno della lista. La ricerca avviene usando l'identificativo.
     * @param id l'identificativo del magazzino che si vuole ricercare.
     * @return il magazzino se é presente, null altrimenti.
     */
    public Magazzino getMagazzino(int id){
        for(Magazzino m : magazzini){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }
}

