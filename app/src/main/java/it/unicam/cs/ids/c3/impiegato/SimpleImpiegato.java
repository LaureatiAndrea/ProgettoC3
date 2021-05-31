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

    public SimpleImpiegato(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
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
    public String toString() {
        return id + " - " + cognome + " " + nome + ", id negozio " + idNegozio;
    }
}
