package it.unicam.cs.ids.c3;

/**
 * Classe di default che implementa l'interfaccia Commerciante.
 */
public class SimpleCommerciante implements Commerciante {

    private String nome;
    private String cognome;
    private String partitaIva;

    public SimpleCommerciante(String nome, String cognome, String partitaIva) {
        this.nome = nome;
        this.cognome = cognome;
        this.partitaIva = partitaIva;
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
    public String getPartitaIva() {
        return partitaIva;
    }

    @Override
    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }
}
