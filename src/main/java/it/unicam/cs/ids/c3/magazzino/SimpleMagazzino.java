package it.unicam.cs.ids.c3.magazzino;


/**
 * Classe di default che implementa l'interfaccia Magazzino.
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
}
