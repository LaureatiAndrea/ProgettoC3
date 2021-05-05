package it.unicam.cs.ids.c3.magazziniere;

/**
 * Rappresenta un generico magazziniere.
 */
public interface Magazziniere {

    /**
     * @return il nome del magazziniere.
     */
    String getNome();

    /**
     * @param nome il nuovo nome del magazziniere.
     */
    void setNome(String nome);

    /**
     * @return il cognome del magazziniere.
     */
    String getCognome();

    /**
     * @param cognome il nuovo cognome del magazziniere.
     */
    void setCognome(String cognome);
}
