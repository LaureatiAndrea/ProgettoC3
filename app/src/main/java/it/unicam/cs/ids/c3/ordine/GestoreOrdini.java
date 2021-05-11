package it.unicam.cs.ids.c3.ordine;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire tutti gli ordini nel sistema C3.
 * Mette a disposizioni metodi per accedere, modificare e rimuovere ordini.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreOrdini {

    private static GestoreOrdini instance;
    private ArrayList<Ordine> ordini;
    private Ordine temp;

    /**
     * Metodo per ottenere l'istanza del GestoreOrdini ( La classe é implementata come Singleton ).
     * @return l'istanza del GestoreOrdini, creandola se non esiste giá.
     */
    public static GestoreOrdini getInstance(){
        if(instance==null){
            instance = new GestoreOrdini();
        }
        return instance;
    }

    public GestoreOrdini(){
        this.ordini = new ArrayList<>();
        //TODO : Eliminare ( Dati di prova, vanno sostituiti con un database nella prossima iterazione )
    }

    public ArrayList<Ordine> getOrdini(){
        return this.ordini;
    }
    /**
     * Aggiunge un ordine alla lista degli ordini
     * @param toAdd l'ordine da aggiungere
     */
    public void addOrdine(Ordine toAdd){
        this.ordini.add(toAdd);
    }

    /**
     * Restituisce un ordine specifico. La ricerca avviene usando l'id.
     * @param id l'id dell'ordine da restituire.
     * @return l'ordine se esiste, null altrimenti.
     */
    public Ordine getOrdine(int id){
        for(Ordine o : this.ordini){
            if(o.getID()==id){
                return o;
            }
        }
        return null;
    }

    /**
     * Rimuovere un ordine dalla lista.
     * @param id l'id dell'ordine da rimuovere.
     */
    public void removeOrdine(int id){
        for(Ordine o : this.ordini){
            if(o.getID()==id){
                ordini.remove(o);
            }
        }
    }

    /**
     * Restituisce l'ordine temporaneo. Temp rappresenta un ordine in fase di costruzione.
     * @return l'ordine temporaneto.
     */
    public Ordine getTemp(){
        return this.temp;
    }

    /**
     * Elimina l'ordine temporaneo. Temp rappresenta un ordine in fase di costruzione.
     */
    public void clearTemp(){
        this.temp = null;
    }

    /**
     * @param temp l'ordine temporaneo da impostare.
     */
    public void setTemp(Ordine temp){
        this.temp = temp;
    }

    public ArrayList<Ordine> getOrdiniInNegozio(){
        ArrayList<Ordine> toReturn = new ArrayList<>();
        for(Ordine o : this.ordini){
            if(o.getStatoOrdine().equals(Stato_Ordine.IN_NEGOZIO)){
                toReturn.add(o);
            }
        }
        return toReturn;
    }
}
