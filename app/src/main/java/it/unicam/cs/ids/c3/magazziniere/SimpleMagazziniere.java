package it.unicam.cs.ids.c3.magazziniere;

/**
 * Classe di default che implementa l'interfaccia Magazziniere.
 */
public class SimpleMagazziniere implements Magazziniere {

    private String nome;
    private String cognome;

    public SimpleMagazziniere(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
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
}
