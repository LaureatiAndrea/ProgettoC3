package it.unicam.cs.ids.c3.corriere;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilita di descrivere un corriere del sistema C3.
 * Queste classi devono mettere a disposizioni metodi per accedere e modificare i dati del corriere.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public interface Corriere {

    /**
     * @return l'ID del corriere.
     */
    int getId();

    /**
     * @param id il nuovo id del corriere.
     */
    void setId(int id);

    /**
     * @return il nome del corriere.
     */
    String getNome();

    /**
     * @param nome il nuovo nome del corriere.
     */
    void setNome(String nome);

    /**
     * @return il cognome del corriere.
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
