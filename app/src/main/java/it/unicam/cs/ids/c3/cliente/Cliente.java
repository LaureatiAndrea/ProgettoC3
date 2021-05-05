package it.unicam.cs.ids.c3.cliente;

/**
 * Le classi che implementano questa interfaccia descrivono un cliente del sistema c3.
 * Queste classi devono mettere a disposizione metodi per ottenere e modificare i dati del cliente.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public interface Cliente {

    /**
     * @return l'ID del cliente
     */
    int getId();

    /**
     * @param id il nuovo id del cliente
     */
    void setId(int id);

    /**
     * @return il nome del cliente
     */
    String getNome();

    /**
     * @param nome il nuovo nome del cliente
     */
    void setNome(String nome);

    /**
     * @return il cognome del cliente
     */
    String getCognome();

    /**
     * @param cognome il nuovo cognome del cliente
     */
    void setCognome(String cognome);

    /**
     * @return l'indirizzo del cliente
     */
    String getIndirizzo();

    /**
     * @param indirizzo il nuovo indirizzo
     */
    void setIndirizzo(String indirizzo);

}
