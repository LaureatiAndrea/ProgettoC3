package it.unicam.cs.ids.c3.cliente;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire i clienti registrati nel sistema C3.
 * Mette a disposizioni metodi per accedere, modificare e rimuovere clienti.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreClienti {

    private ArrayList<Cliente> clienti;
    private static GestoreClienti instance;

    /**
     * Metodo per ottenere l'istanza del GestoreClienti ( La classe é implementata come Singleton ).
     * @return l'istanza del GestoreClienti, creandola se non esiste giá.
     */
    public static GestoreClienti getInstance(){
        if(instance==null){
            instance = new GestoreClienti();
        }
        return instance;
    }

    public GestoreClienti(){
        clienti = new ArrayList<>();
        //TODO : Eliminare ( Dati di prova, vanno sostituiti con un database nella prossima iterazione )
        clienti.add(new SimpleCliente(1, "Andrea", "Laureati", "via fontepezzana 44"));
        clienti.add(new SimpleCliente(2, "Marco", "Gaetani", "via colleappeso 12"));
        clienti.add(new SimpleCliente(12, "Francesco", "Amadio", "via Pressa 10"));
    }

    /**
     * Aggiunge un cliente alla lista dei clienti.
     * @param c il cliente da aggiungere.
     */
    public void addCliente(Cliente c){
        clienti.add(c);
    }

    /**
     * Rimuove un cliente dalla lista dei clienti.
     * @param c il cliente da rimuovere.
     */
    public void removeCliente(Cliente c){
        clienti.remove(c);
    }

    /**
     * Ricerca uno specifico cliente all'interno della lista. La ricerca avviene usando l'identificativo.
     * @param id l'identificativo del cliente che si vuole ricercare.
     * @return il cliente se é presente, null altrimenti.
     */
    public Cliente getCliente(int id){
        for(Cliente c : clienti){
            if (c.getId() == id )
            return c;
        }
        return null;
    }

    /**
     * Restituisce la lista di tutti i clienti registrati al sistema C3.
     * @return la lista dei clienti registrati.
     */
    public ArrayList<Cliente> getClienti(){
        return this.clienti;
    }
}
