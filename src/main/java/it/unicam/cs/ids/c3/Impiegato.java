package it.unicam.cs.ids.c3;

/**
 * Rappresenta l'impiegato di un negozio.
 */
public interface Impiegato {

    /**
     * @return il nome dell'impiegato.
     */
    String getNome();

    /**
     * @param nome il nuovo nome.
     */
    void setNome(String nome);

    /**
     * @return il cognome dell'impiegato.
     */
    String getCognome();

    /**
     * @param cognome il nuovo cognome.
     */
    void setCognome(String cognome);

}
