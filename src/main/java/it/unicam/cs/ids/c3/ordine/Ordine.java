package it.unicam.cs.ids.c3.ordine;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilità di descrivere un ordine del sistema C3.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco
 */
public interface Ordine {

    /**
     * @return l'id dell'ordine
     */
    int getID();

    /**
     * @param id il nuovo id dell'ordine
     */
    void setId(int id);
    /**
     * @return l'ID del it.unicam.cs.ids.c3.cliente
     */
    int getIdCliente();

    /**
     * @param idCliente il nuovo ID del it.unicam.cs.ids.c3.cliente
     */
    void setIdCliente(int idCliente);

    /**
     * @return la destinazione dell'ordine
     */
    String getDestinazione();

    /**
     * @param destinazione la destinazione dell' ordine
     */
    void setDestinazione(String destinazione);

    /**
     * @return il codice usato dal it.unicam.cs.ids.c3.cliente per ritirare la merce
     */
    int getCodiceRitiro();

    /**
     * @param codiceRitiro il nuovo codice per il ritiro della merce
     */
    void setCodiceRitiro(int codiceRitiro);

    /**
     * @return lo stato dell'ordine
     */
    Stato_Ordine getStatoOrdine();

    /**
     * @param statoOrdine il nuovo stato dell'ordine
     */
    void setStatoOrdine(Stato_Ordine statoOrdine);
}
