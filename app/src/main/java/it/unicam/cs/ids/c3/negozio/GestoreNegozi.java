package it.unicam.cs.ids.c3.negozio;

import java.util.ArrayList;

/**
 * Questa classe si occupa di gestire i negozi registrati nel sistema C3.
 * Mette a disposizione metodi per accedere, modificare, rimuovere i negozi.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreNegozi {

    private static GestoreNegozi instance;
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
        this.negozi = new ArrayList<>();
        //TODO : Eliminare ( Dati di prova, vanno sostituiti con un database nella prossima iterazione )
        this.negozi.add(new SimpleNegozio(1, "Conad", "Via turati 10", Categoria_Merceologica.ALIMENTARI));
        this.negozi.add(new SimpleNegozio(2, "Euronics", "Via monitor 2", Categoria_Merceologica.ELETTRONICA));
        this.negozi.add(new SimpleNegozio(3, "AbbigliaTutto", "Via pasubio 21", Categoria_Merceologica.ABBIGLIAMENTO));

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
