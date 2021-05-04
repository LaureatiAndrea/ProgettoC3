package it.unicam.cs.ids.c3.impiegato;

/**
 * Classe di default che implementa l'interfaccia Impiegato.
 */
public class SimpleImpiegato implements Impiegato {

    private int id;
    private String nome;
    private String cognome;

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
