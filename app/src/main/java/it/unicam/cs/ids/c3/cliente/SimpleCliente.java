package it.unicam.cs.ids.c3.cliente;

import java.util.Objects;

/**
 * Questa classe descrive un cliente del sistema C3, caratterizzato da un id, nome, cognome ed indirizzo.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class SimpleCliente implements Cliente {

    private int id;
    private String nome;
    private String cognome;
    private String indirizzo;


    public SimpleCliente(int id, String nome, String cognome, String indirizzo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id){
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getCognome() {
        return cognome;
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String getIndirizzo() {
        return indirizzo;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public boolean equals(Object o) {
        //Due clienti sono considerati uguali se hanno stesso nome, cognome ed indirizzo.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleCliente that = (SimpleCliente) o;
        return getNome().equals(that.getNome()) && getCognome().equals(that.getCognome()) && getIndirizzo().equals(that.getIndirizzo());
    }

    @Override
    public int hashCode() {
        //L'hashcode é coerente con l'equals.
        return Objects.hash(getNome(), getCognome(), getIndirizzo());
    }

    @Override
    public String toString() {
        //Restituisce una descrizione nel formato " ID - Cognome Nome , Indirizzo "
        return id + " - " + cognome + " " + nome + " , " + indirizzo;
    }
}
