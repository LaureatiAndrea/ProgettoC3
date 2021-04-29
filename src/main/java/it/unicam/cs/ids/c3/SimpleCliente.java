package it.unicam.cs.ids.c3;

/**
 * Classe di default che implementa l'interfaccia Cliente.
 */
public class SimpleCliente implements Cliente {

    private String nome;
    private String cognome;
    private String indirizzo;

    public SimpleCliente(String nome, String cognome, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
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
}
