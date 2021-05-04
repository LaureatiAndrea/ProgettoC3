package it.unicam.cs.ids.c3.negozio;

import java.util.ArrayList;

public class GestoreNegozi {

    private static GestoreNegozi instance;
    private ArrayList<Negozio> negozi;

    /**
     * Restituisce l'istanza singleton del gestore negozi
     * @return l'istanza creandola se non é presente
     */
    public static GestoreNegozi getInstance(){
        if(instance==null){
            instance = new GestoreNegozi();
        }
        return instance;
    }

    public GestoreNegozi(){
        this.negozi = new ArrayList<>();
    }

    private void addNegozio(Negozio toAdd){
        this.negozi.add(toAdd);
    }

    private Negozio getNegozio(int id){
        for(Negozio n : negozi){
            if(n.getId()==id){
                return n;
            }
        }
        return null;
    }

    private void removeNegozio(int id){
        for(Negozio n : negozi){
            if(n.getId()==id){
                negozi.remove(n);
            }
        }
    }


}
