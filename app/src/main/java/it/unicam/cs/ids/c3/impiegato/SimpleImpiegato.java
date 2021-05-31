package it.unicam.cs.ids.c3.impiegato;

import java.util.Objects;

/**
 * La classe ha la responsabilitá di descrivere un imipiegato, con un suo identificativo, nome cognome e negozio in cui lavora.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleImpiegato that = (SimpleImpiegato) o;
        return getIdNegozio() == that.getIdNegozio() && getNome().equals(that.getNome()) && getCognome().equals(that.getCognome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCognome(), getIdNegozio());
    }

    @Override
    public String toString() {
        return id + " - " + cognome + " " + nome + ", id negozio " + idNegozio;
    }
}
