package it.unicam.cs.ids.c3.commerciante;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilitá di descrivere un commerciante, inteso come
 * il proprietario di un negozio che utilizza il sistema C3.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public interface Commerciante {
    /**
     * @return l'id del commerciante.
     */
    int getId();

    /**
     * @param id il nuovo id del commerciante.
     */
    void setId(int id);
    /**
     * @return il nome del commerciante.
     */
    String getNome();

    /**
     * @param nome il nuovo nome del commerciante.
     */
    void setNome(String nome);

    /**
     * @return il cognome del commerciante.
     */
    String getCognome();

    /**
     * @param cognome il nuovo cognome del commerciante.
     */
    void setCognome(String cognome);

    /**
     * @return la partita iva del commerciante.
     */
    String getPartitaIva();

    /**
     * @param partitaIva la nuova partita iva del commerciante.
     */
    void setPartitaIva(String partitaIva);

}
