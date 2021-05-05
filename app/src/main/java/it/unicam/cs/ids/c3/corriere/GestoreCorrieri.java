package it.unicam.cs.ids.c3.corriere;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire i corrieri registrati nel sistema C3.
 * Mette a disposizione metodi per accedere, modificare, rimuovere clienti.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreCorrieri {

    private ArrayList<Corriere> corrieri;
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
        corrieri = new ArrayList<>();
        //TODO : Eliminare ( Dati di prova, vanno sostituiti con un database nella prossima iterazione )
        corrieri.add(new SimpleCorriere(1, "Claudio", "Barchetto"));
        corrieri.add(new SimpleCorriere(2, "Paolo", "Bitta"));
        corrieri.add(new SimpleCorriere(3, "Enrico", "Papi"));
    }

    /**
     * Aggiunge un corriere alla lista dei corrieri.
     * @param c il corriere da aggiungere.
     */
    public void addCorriere(Corriere c){
        corrieri.add(c);
    }

    /**
     * Rimuove un corriere dalla lista dei corrieri.
     * @param c il corriere da rimuovere.
     */
    public void removeCliente(Corriere c){
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
}
