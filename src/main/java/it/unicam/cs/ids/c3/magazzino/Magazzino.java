package it.unicam.cs.ids.c3.magazzino;

/**
 * Rappresenta un generico magazzino dove viene depositata la merce.
 */
public interface Magazzino {

    /**
     * @return l'ID del magazzino.
     */
    int getId();

    /**
     * @return il nome del magazzino.
     */
    String getNome();

    /**
     * @param nome il nuovo nome del magazzino.
     */
    void setNome(String nome);

    /**
     * @return l'indirizzo del magazzino.
     */
    String getIndirizzo();

    /**
     * @param indirizzo il nuovo indirizzo del magazzino.
     */
    void setIndirizzo(String indirizzo);


}
