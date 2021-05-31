package it.unicam.cs.ids.c3.commerciante;

/**
 * Questa classe descrive un commerciante, cioé il proprietario di un negozio con un nome, cognome e partita iva.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class SimpleCommerciante implements Commerciante {

    private int id;
    private String nome;
    private String cognome;
    private String partitaIva;

    public SimpleCommerciante(int id, String nome, String cognome, String partitaIva) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.partitaIva = partitaIva;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
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
    public String getPartitaIva() {
        return partitaIva;
    }

    @Override
    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }
}
