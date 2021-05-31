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
     * Ritorna tutti i negozi contenuti nel gestore
     * @return ArrayList di tutti i negozi contenuti nel gestore.
     */
    public ArrayList<Negozio> getNegozi() {
        return this.negozi;
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

    /**
     * Ritorna la lista delle categorie vendute dai vari negozi, come stringhe
     * @return la lista delle categorie come arraylist di stringhe
     */
    public ArrayList<String> getCategorieAsStrings() {
        ArrayList<String> toReturn = new ArrayList<>();
        for(Negozio n : this.negozi){
            if(!toReturn.contains(n.getCategoria().name())){
                toReturn.add(n.getCategoria().name());
            }
        }
        return toReturn;
    }

    /**
     * Ritorna tutti i negozi che vendono una determinata categoria merceologica
     * @param categoria la categoria in base alla quale si vogliono filtrare i negozi
     * @return i negozi che vendono quella categoria merceologica
     */
    public ArrayList<Negozio> getNegoziByCategoria(String categoria) {
        Categoria_Merceologica cat = Categoria_Merceologica.valueOf(categoria);
        ArrayList<Negozio> toReturn = new ArrayList<>();
        for(Negozio n : negozi){
            if(n.getCategoria().equals(cat)){
                toReturn.add(n);
            }
        }
        return toReturn;
    }

    /**
     * Restituisce la lista dei soli negozi con promozioni attive al momento della richiesta.
     * @return la lista dei negozi con promozioni
     */
    public ArrayList<Negozio> getNegoziConPromozioni() {
        ArrayList<Negozio> toReturn = new ArrayList<>();
        for (Negozio n : this.negozi) {
            for (Promozione p : n.getPromozioni()) {
                if(p.getStatoPromozione() == true) {
                    toReturn.add(n);
                }
            }
        }
        return toReturn;
    }

    /**
     * Restituisce la lista dei negozi con promozioni attive di una determinata categoria
     * @param categoria la categoria che si vuole filtrare
     * @return la lista dei negozi di quella categoria, con promozioni attive.
     */
    public ArrayList<Negozio> getNegoziConPromozioniByCategoria(String categoria) {
        Categoria_Merceologica cat = Categoria_Merceologica.valueOf(categoria);
        ArrayList<Negozio> toReturn = new ArrayList<>();
        for (Negozio n : getNegoziConPromozioni()) {
            if(n.getCategoria().equals(cat)) {
                toReturn.add(n);
            }
        }
        return toReturn;
    }

}
