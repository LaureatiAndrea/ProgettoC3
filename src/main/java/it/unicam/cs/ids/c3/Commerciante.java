package it.unicam.cs.ids.c3;

/**
 * Rappresenta il proprietario di uno o piu' negozi.
 */
public interface Commerciante {

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
