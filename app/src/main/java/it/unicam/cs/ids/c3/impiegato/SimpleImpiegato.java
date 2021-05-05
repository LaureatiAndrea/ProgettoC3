package it.unicam.cs.ids.c3.impiegato;

import java.util.Objects;

/**
 * Classe di default che implementa l'interfaccia Impiegato.
 */
public class SimpleImpiegato implements Impiegato {

    private int id;
    private String nome;
    private String cognome;
    private int idNegozio;

    public SimpleImpiegato(int id, String nome, String cognome,int idNegozio) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.idNegozio = idNegozio;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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
    public int getIdNegozio() {
        return this.idNegozio;
    }

    @Override
    public void setIdNegozio(int idNegozio) {
        this.idNegozio = idNegozio;
    }

    @Override
    public boolean equals(Object o) {
        //Due impiegati con lo stesso nome e cognome, e lo stesso negozio sono uguali
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleImpiegato that = (SimpleImpiegato) o;
        return getIdNegozio() == that.getIdNegozio() && getNome().equals(that.getNome()) && getCognome().equals(that.getCognome());
    }

    @Override
    public int hashCode() {
        //L'hashcode é coerente con l'equals
        return Objects.hash(getNome(), getCognome(), getIdNegozio());
    }

    @Override
    public String toString() {
        //Restituisce una descrizione dell'impiegato nel formato "ID - Cognome Nome, id negozio 132"
        return id + " - " + cognome + " " + nome + ", id negozio " + idNegozio;
    }
}
