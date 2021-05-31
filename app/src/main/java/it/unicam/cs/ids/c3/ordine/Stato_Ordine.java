package it.unicam.cs.ids.c3.ordine;

/**
 * Rappresenta lo stato dell'ordine.
 * IN NEGOZIO significa che l'ordine é stato creato e deve essere ritirato dal corriere presso il negozio
 * TRASPORTO IN CORSO significa che il corriere sta trasportando a destinazione il pacco
 * DEPOSITATO IN MAGAZZINO indica che l'ordine é stato depositato presso il magazzino prescelto
 * CONSEGNATO AL CLIENTE indica che il cliente ha ritirato l'ordine dal magazzino, oppure che il corriere ha consegnato a domicilio l'ordine.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public enum Stato_Ordine {
    IN_NEGOZIO,
    TRASPORTO_IN_CORSO,
    DEPOSITATO_IN_MAGAZZINO,
    CONSEGNATO_AL_CLIENTE
}
