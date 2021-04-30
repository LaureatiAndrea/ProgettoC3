package it.unicam.cs.ids.c3;

/**
 * Rappresenta un generico corriere addetto al trasporto delle merci.
 */
public interface Corriere {

    /**
     * @return il nome del corriere.
     */
    String getNome();

    /**
     * @param nome il nuovo nome del corriere.
     */
    void setNome(String nome);

    /**
     * @return il cognome del corrire.
     */
    String getCognome();

    /**
     * @param cognome il nuovo nome del corriere.
     */
    void setCognome(String cognome);

    /**
     * @return lo stato del corriere.
     */
    Stato_Corriere getStato();

    /**
     * @param statoCorriere il nuovo stato del corriere.
     */
    void setStato(Stato_Corriere statoCorriere);

}
