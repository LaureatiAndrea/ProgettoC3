package it.unicam.cs.ids.c3.corriere;

import java.util.ArrayList;

public class GestoreCorrieri {

    private ArrayList<Corriere> corrieri;
    private static GestoreCorrieri instance;

    public GestoreCorrieri getInstance(){
        if(instance==null){
            instance = new GestoreCorrieri();
        }
        return instance;
    }

    public GestoreCorrieri(){
        corrieri = new ArrayList<>();
    }

    public void addCorriere(Corriere c){
        corrieri.add(c);
    }

    public void removeCliente(Corriere c){
        corrieri.remove(c);
    }

    public Corriere getCorriere(int id){
        for(Corriere c : corrieri){
            if (c.getId() == id )
                return c;
        }
        return null;
    }
}
