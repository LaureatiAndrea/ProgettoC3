package it.unicam.cs.ids.c3.corriere;

/**
 * Classe di default che implementa l'interfaccia Corriere.
 */
public class SimpleCorriere implements Corriere {

    private int id;
    private String nome;
    private String cognome;
    private Stato_Corriere statoCorriere;

    public SimpleCorriere(int id, String nome, String cognome, Stato_Corriere statoCorriere) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.statoCorriere = statoCorriere;
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
