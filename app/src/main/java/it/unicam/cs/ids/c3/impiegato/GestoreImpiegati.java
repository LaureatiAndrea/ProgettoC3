package it.unicam.cs.ids.c3.impiegato;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire gli impiegati registrati nel sistema C3.
 * Mette a disposizione metodi per accedere, modificare, rimuovere gli impiegati.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreImpiegati {

    private ArrayList<Impiegato> impiegati;
    private static GestoreImpiegati instance;

    /**
     * Metodo per ottenere l'istanza del GestoreImpiegati ( La classe é implementata come Singleton ).
     * @return l'istanza del GestoreImpiegati, creandola se non esiste giá.
     */
    public static GestoreImpiegati getInstance(){
        if(instance==null){
            instance = new GestoreImpiegati();
        }
        return instance;
    }

    public GestoreImpiegati(){
        //TODO : Implementare interazione con il db.
        impiegati = new ArrayList<>();
    }

    /**
     * Aggiunge un impiegato alla lista degli impiegati.
     * @param c l'impiegato da aggiungere.
     */
    public void addCliente(Impiegato c){
        impiegati.add(c);
    }

    /**
     * Rimuove un impiegato dalla lista degli impiegati.
     * @param c l'impiegato da rimuovere.
     */
    public void removeImpiegato(Impiegato c){
        impiegati.remove(c);
    }

    /**
     * Ricerca uno specifico impiegato all'interno della lista. La ricerca avviene usando l'identificativo.
     * @param id l'identificativo dell'impiegato che si vuole ricercare.
     * @return l'impiegato se é presente, null altrimenti.
     */
    public Impiegato getImpiegato(int id){
        for(Impiegato c : impiegati){
            if (c.getId() == id )
                return c;
        }
        return null;
    }

    /**
     * Restituisce la lista di tutti gli impiegati registrati al sistema C3.
     * @return la lista degli impiegati registrati.
     */
    public ArrayList<Impiegato> getImpiegati(){
        return this.impiegati;
    }

}
