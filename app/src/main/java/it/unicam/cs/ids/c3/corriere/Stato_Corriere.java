package it.unicam.cs.ids.c3.corriere;

/**
 * Enumerazione che descrive lo stato del corriere.
 * Un corriere Disponibile si rende disponibile ad effettuare consegne. Viceversa, un corriere non disponibile non si
 * rende disponibile ad effettuare consegne e non gli verranno assegnati ordini.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */

public enum Stato_Corriere {
    DISPONIBILE,
    NON_DISPONIBILE
}
