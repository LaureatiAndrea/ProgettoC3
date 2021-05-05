package it.unicam.cs.ids.c3.magazzino;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilita di descrivere un punto di ritiro della merce.
 * Queste classi devono mettere a disposizione metodi per accedere e modificare i dati del magazzino.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
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
