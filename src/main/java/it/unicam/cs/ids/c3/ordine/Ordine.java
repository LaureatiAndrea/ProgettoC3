package it.unicam.cs.ids.c3.ordine;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilità di descrivere un ordine del sistema C3.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco
 */
public interface Ordine {

    /**
     * @return l'ID del cliente
     */
    int getIdCliente();

    /**
     * @param idCliente il nuovo ID del cliente
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
     * @return il codice usato dal cliente per ritirare la merce
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
