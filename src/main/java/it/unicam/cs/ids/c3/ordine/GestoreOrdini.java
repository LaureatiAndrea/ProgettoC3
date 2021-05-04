package it.unicam.cs.ids.c3.ordine;

import java.util.ArrayList;

public class GestoreOrdini {

    private static GestoreOrdini instance;
    private ArrayList<Ordine> ordini;
    private Ordine temp;

    public static GestoreOrdini getInstance(){
        if(instance==null){
            instance = new GestoreOrdini();
        }
        return instance;
    }

    public GestoreOrdini(){
        this.ordini = new ArrayList<>();
    }

    public void addOrdine(Ordine toAdd){
        this.ordini.add(toAdd);
    }

    public Ordine getOrdine(int id){
        for(Ordine o : this.ordini){
            if(o.getID()==id){
                return o;
            }
        }
        return null;
    }

    public void removeOrdine(int id){
        for(Ordine o : this.ordini){
            if(o.getID()==id){
                ordini.remove(o);
            }
        }
    }

    public Ordine getTemp(){
        return this.temp;
    }

    public  void clearTemp(){
        this.temp = null;
    }

    public void setTemp(Ordine temp){
        this.temp = temp;
    }
}
