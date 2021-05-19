package it.unicam.cs.ids.c3.negozio;

import it.unicam.cs.ids.c3.database.MySqlDatabase;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire i negozi registrati nel sistema C3.
 * Mette a disposizione metodi per accedere, modificare, rimuovere i negozi.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreNegozi {

    private static GestoreNegozi instance;
    private MySqlDatabase db;
    private ArrayList<Negozio> negozi;

    /**
     * Metodo per ottenere l'istanza del GestoreNegozi ( La classe é implementata come Singleton ).
     * @return l'istanza del GestoreNegozi, creandola se non esiste giá.
     */
    public static GestoreNegozi getInstance(){
        if(instance==null){
            instance = new GestoreNegozi();
        }
        return instance;
    }

    public GestoreNegozi(){
        db = MySqlDatabase.getInstance();
        negozi = db.getAllNegozi();
    }

    /**
     * Aggiunge un negozio alla lista dei negozi che usano il sistema C3.
     * @param toAdd il negozio da aggiungere.
     */
    public void addNegozio(Negozio toAdd){
        this.negozi.add(toAdd);
    }

    /**
     * Ricerca un negozio specifico nella lista. La ricerca avviene usando l'id del negozio.
     * @param id l'id del negozio da cercare
     * @return il negozio se esiste, null altrimenti.
     */
    public Negozio getNegozio(int id){
        for(Negozio n : negozi){
            if(n.getId()==id){
                return n;
            }
        }
        return null;
    }

    /**
     * Rimuove un negozio dalla lista dei negozi che usano il sistema C3.
     * @param id l'id del negozio da rimuovere.
     */
    public void removeNegozio(int id){
        for(Negozio n : negozi){
            if(n.getId()==id){
                negozi.remove(n);
            }
        }
    }


}
