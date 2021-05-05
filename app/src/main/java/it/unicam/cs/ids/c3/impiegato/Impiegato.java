package it.unicam.cs.ids.c3.impiegato;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilita di descrivere un impiegato di un negozio
 * che utilizza il sistema C3.
 * Queste classi devono mettere a disposizione i metodi per accedere e modificare i dati dell'impiegato.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public interface Impiegato {

    /**
     * @return l'ID dell'impiegato.
     */
    int getId();

    /**
     * @param id il nuovo ID dell'impiegato.
     */
    void setId(int id);

    /**
     * @return il nome dell'impiegato.
     */
    String getNome();

    /**
     * @param nome il nuovo nome dell'impiegato.
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

    /**
     * @return l'ID del negozio dove lavora l'impiegato.
     */
    int getIdNegozio();

    /**
     * @param idNegozio il nuovo ID del negozio in cui lavora l'impiegato.
     */
    void setIdNegozio(int idNegozio);


}
