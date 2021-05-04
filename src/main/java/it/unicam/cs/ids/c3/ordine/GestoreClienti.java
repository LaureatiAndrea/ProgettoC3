package it.unicam.cs.ids.c3.cliente;

import java.util.ArrayList;

public class GestoreClienti {

    private ArrayList<Cliente> clienti;
    private static GestoreClienti instance;

    public static GestoreClienti getInstance(){
        if(instance==null){
            instance = new GestoreClienti();
        }
        return instance;
    }

    public GestoreClienti(){
        clienti = new ArrayList<>();
        //Eliminare
        clienti.add(new Cliente(1, "Andrea", "Laureati"));
        clienti.add(new Cliente(2, "Marco", "Gaetani"));
    }

    public void addCliente(Cliente c){
        clienti.add(c);
    }

    public void removeCliente(Cliente c){
        clienti.remove(c);
    }

    public Cliente getCliente(int id){
        for(Cliente c : clienti){
            if (c.getId() == id )
            return c;
        }
        return null;
    }

    public ArrayList<Cliente> getClienti(){
        return this.clienti;
    }
}
