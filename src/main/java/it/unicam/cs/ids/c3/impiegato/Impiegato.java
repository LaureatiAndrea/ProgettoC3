package it.unicam.cs.ids.c3.impiegato;

/**
 * Rappresenta un generico impiegato di un negozio.
 */
public interface Impiegato {

    /**
     * @return l'ID dell'impiegato.
     */
    int getId();

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
