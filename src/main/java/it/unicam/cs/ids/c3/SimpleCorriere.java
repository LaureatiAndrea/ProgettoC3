package it.unicam.cs.ids.c3;

/**
 * Classe di default che implementa l'interfaccia Corriere.
 */
public class SimpleCorriere implements Corriere {

    private String nome;
    private String cognome;
    private Stato_Corriere statoCorriere;

    public SimpleCorriere(String nome, String cognome, Stato_Corriere statoCorriere) {
        this.nome = nome;
        this.cognome = cognome;
        this.statoCorriere = statoCorriere;
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
}
