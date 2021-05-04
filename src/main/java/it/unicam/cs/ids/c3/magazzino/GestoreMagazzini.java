package it.unicam.cs.ids.c3.magazzino;

import java.util.ArrayList;

public class GestoreMagazzini {

    private ArrayList<Magazzino> magazzini;
    private static GestoreMagazzini instance;

    public static GestoreMagazzini getInstance(){
        if(instance == null){
            instance = new GestoreMagazzini();
        }
        return instance;
    }

    public GestoreMagazzini(){
        this.magazzini = new ArrayList<>();
        //Cancellare
        this.magazzini.add(new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22"));
        this.magazzini.add(new SimpleMagazzino(2, "Magazzino Centrale", "Via P.Fossa 144"));
    }

    public void addMagazzino(Magazzino m){
        magazzini.add(m);
    }

    public void removeMagazzino(Magazzino m){
        magazzini.remove(m);
    }

    public ArrayList<Magazzino> getMagazzini(){
        return this.magazzini;
    }

    public Magazzino getMagazzino(int id){
        for(Magazzino m : magazzini){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }
}

