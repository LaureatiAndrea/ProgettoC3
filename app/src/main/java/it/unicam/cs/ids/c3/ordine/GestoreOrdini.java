package it.unicam.cs.ids.c3.ordine;

import it.unicam.cs.ids.c3.database.MySqlDatabase;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire tutti gli ordini nel sistema C3.
 * Mette a disposizioni metodi per accedere, modificare e rimuovere ordini.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreOrdini {

    private static GestoreOrdini instance;
    private MySqlDatabase db;
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
        db = MySqlDatabase.getInstance();
        ordini = db.getAllOrdini();
    }

    public int getNextId() {
        //TODO : ritorna null perche non ho implementato getAllOrdini dal database.
        return (ordini.get(ordini.size()-1).getID())+1;
    }

    public ArrayList<Ordine> getOrdini(){
        return this.ordini;
    }
    /**
     * Aggiunge un ordine alla lista degli ordini
     * @param toAdd l'ordine da aggiungere
     */
    public void addOrdine(Ordine toAdd){
        db.addOrdine(toAdd);
        this.ordini = db.getAllOrdini();
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

    /**
     * Setta lo stato di un particolare ordine
     * @param idOrdine l'id dell'ordine da modificare
     * @param statoOrdine il nuovo stato dell'ordine
     */
    public void setStatoOrdine(int idOrdine, Stato_Ordine statoOrdine) {
        db.setStatoOrdine(idOrdine, statoOrdine.name());
    }

    /**
     * aggiorna la lista con i valori presenti nel database.
     */
    public void updateList() {
        //TODO : Aggiorna la lista con i valori del database
        this.ordini = db.getAllOrdini();
    }

    /**
     * Restituisce soltanto gli ordini che abbiano lo stato IN_VIAGGIO
     * @return la lista degli ordini
     */
    public ArrayList<Ordine> getOrdiniInViaggio() {
        ArrayList<Ordine> toReturn = new ArrayList<>();
        for(Ordine o : this.ordini){
            if(o.getStatoOrdine().equals(Stato_Ordine.TRASPORTO_IN_CORSO)){
                toReturn.add(o);
            }
        }
        return toReturn;
    }

    /**
     * Restituisce soltanto gli ordini che abbiano lo stato CONSEGNATO_AL_CLIENTE
     * @return la lista degli ordini
     */
    public ArrayList<Ordine> getOrdiniConsegnati() {
        ArrayList<Ordine> toReturn = new ArrayList<>();
        for(Ordine o : this.ordini){
            if(o.getStatoOrdine()==Stato_Ordine.CONSEGNATO_AL_CLIENTE){
                toReturn.add(o);
            }
        }
        return toReturn;
    }

    /**
     * Restituisce la lista degli ordini con stato DEPOSITATO_IN_MAGAZZINO
     * @return la lista degli ordini
     */
    public ArrayList<Ordine> getOrdiniDepositati() {
        ArrayList<Ordine> toReturn = new ArrayList<>();
        for(Ordine o : this.ordini){
            if(o.getStatoOrdine()==Stato_Ordine.DEPOSITATO_IN_MAGAZZINO){
                toReturn.add(o);
            }
        }
        return toReturn;
    }
}
