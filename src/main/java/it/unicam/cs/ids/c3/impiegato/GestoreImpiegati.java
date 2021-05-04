package it.unicam.cs.ids.c3.impiegato;

import java.util.ArrayList;

public class GestoreImpiegati {

    private ArrayList<Impiegato> impiegati;
    private static GestoreImpiegati instance;

    public static GestoreImpiegati getInstance(){
        if(instance==null){
            instance = new GestoreImpiegati();
        }
        return instance;
    }

    public GestoreImpiegati(){
        impiegati = new ArrayList<>();
        //Eliminare
        impiegati.add(new SimpleImpiegato(1, "Andrea", "Laureati"));
        impiegati.add(new SimpleImpiegato(2, "Marco", "Gaetani"));
    }

    public void addCliente(Impiegato c){
        impiegati.add(c);
    }

    public void removeCliente(Impiegato c){
        impiegati.remove(c);
    }

    public Impiegato getImpiegato(int id){
        for(Impiegato c : impiegati){
            if (c.getId() == id )
                return c;
        }
        return null;
    }

    public ArrayList<Impiegato> getClienti(){
        return this.impiegati;
    }

}
