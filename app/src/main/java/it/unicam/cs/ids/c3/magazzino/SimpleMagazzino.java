package it.unicam.cs.ids.c3.magazzino;


import java.util.Objects;

/**
 * Questa classe ha la responsabilitá di descrivere un magazzino, cioé un punto di ritiro per la merce.
 * Ogni magazzino dispone di un identificativo, un nome e un indirizzo.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class SimpleMagazzino implements Magazzino {

    private int id;
    private String nome;
    private String indirizzo;

    public SimpleMagazzino(int id, String nome, String indirizzo) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    @Override
    public int getId() {
        return id;
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
    public String getIndirizzo() {
        return indirizzo;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public boolean equals(Object o) {
        //Due magazzini sono uguali se hanno lo stesso nome e lo stesso indirizzo.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMagazzino that = (SimpleMagazzino) o;
        return getNome().equals(that.getNome()) && getIndirizzo().equals(that.getIndirizzo());
    }

    @Override
    public int hashCode() {
        // hashcode é coerente con l'equals.
        return Objects.hash(getNome(), getIndirizzo());
    }

    @Override
    public String toString() {
        //Restituisce una descrizione del magazzino nel formato "ID - nome, indirizzo"
        return id + " - " + nome + ", " + indirizzo;
    }
}
