package it.unicam.cs.ids.c3;

/**
 * Classe di default che implementa l'interfaccia Magazzino.
 */
public class SimpleMagazzino implements Magazzino {

    private String nome;
    private String indirizzo;

    public SimpleMagazzino(String nome, String indirizzo) {
        this.nome = nome;
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
    public String getIndirizzo() {
        return indirizzo;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
