package it.unicam.cs.ids.c3.corriere;

import java.util.Objects;

/**
 * Questa classe ha la resposabililta di descrivere un corriere del sistema C3.
 * Ogni corriere ha un id, nome , cognome e uno stato di disponibilitá
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class SimpleCorriere implements Corriere {

    private int id;
    private String nome;
    private String cognome;
    private Stato_Corriere statoCorriere;

    public SimpleCorriere(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.statoCorriere = Stato_Corriere.DISPONIBILE;
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
    public Stato_Corriere getStato() {
        return statoCorriere;
    }

    @Override
    public void setStato(Stato_Corriere statoCorriere) {
        this.statoCorriere = statoCorriere;
    }

    @Override
    public boolean equals(Object o) {
        //Due corrieri si considerano uguali se hanno stesso nome e cognome.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleCorriere that = (SimpleCorriere) o;
        return getNome().equals(that.getNome()) && getCognome().equals(that.getCognome());
    }

    @Override
    public int hashCode() {
        //L'hashcode é coerente con l'equals.
        return Objects.hash(getNome(), getCognome());
    }

    @Override
    public String toString() {
        //Restituisce i dettagli del corriere nel formato " ID - Cognome Nome "
        return id + " - " + cognome + " " + nome;
    }
}
