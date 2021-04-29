package it.unicam.cs.ids.c3;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilità di descrivere un cliente del sistema C3
 *
 * @author Laureati Andrea Francesco, Gaetani Marco
 */
public interface Cliente {

    String getNome();
    String setNome();
    String getCognome();
    String setCognome();
    String getIndirizzo();
    String setIndirizzo();
}
