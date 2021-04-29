package it.unicam.cs.ids.c3;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilità di descrivere un cliente del sistema C3
 *
 * @author Laureati Andrea Francesco, Gaetani Marco
 */
public interface Cliente {

    /**
     * @return il nome del cliente.
     */
    String getNome();

    /**
     * @param nome il nuovo nome del cliente.
     */
    void setNome(String nome);

    /**
     * @return il cognome del cliente.
     */
    String getCognome();

    /**
     * @param cognome il nuovo cognome del cliente.
     */
    void setCognome(String cognome);

    /**
     * @return l'indirizzo del cliente.
     */
    String getIndirizzo();

    /**
     * @param indirizzo il nuovo indirizzo.
     */
    void setIndirizzo(String indirizzo);
}
