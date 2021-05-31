package it.unicam.cs.ids.c3.negozio;

import java.util.ArrayList;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilità di descrivere un negozio del sistema C3
 * Queste classi devono mettere a disposizioni metodi per accedere e modificare i dati del negozio, e di gestire
 * le promozioni.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public interface Negozio {

    /**
     * @return l'id del negozio
     */
    int getId();

    /**
     * @param id il nuovo id del negozio
     */
    void setId(int id);

    /**
     * @return il nome del negozio
     */
    String getNome();

    /**
     * @param nome il nuovo nome
     */
    void setNome(String nome);

    /**
     * @return l' indirizzo del negozio
     */
    String getIndirizzo();

    /**
     * @param indirizzo il nuovo indirizzo
     */
    void setIndirizzo(String indirizzo);

    /**
     * @return la categoria merceologica venduta dal negozio
     */
    Categoria_Merceologica getCategoria();

    /**
     * @param cat la nuova categoria
     */
    void setCategoria(Categoria_Merceologica cat);

    /**
     * @return la lista delle promozioni del negozio
     */
    ArrayList<Promozione> getPromozioni();

    /**
     * Imposta una promozione come attiva.
     * @param p la promozione da aggiungere
     */
    void lanciaPromozione(Promozione p);

    /**
     * Imposta una promozione come non attiva.
     * @param p la promozione da terminare.
     */
    void terminaPromozione(Promozione p);

    /**
     * Restituisce un determinata promozione
     * @param id l'identificativo della promozione cercata
     * @return la promozione se viene trovata, null altrimenti
     */
    Promozione getPromozione ( int id);

    /**
     * Aggiunge una promozione alla lista
     * @param p la promozione da aggiungere
     */
    void addPromozione(Promozione p);

    /**
     * Rimuove una promozione dalla lista
     * @param p la promozione da rimuovere
     */
    void removePromozione(Promozione p);

    /**
     * Restituisce la promozione attiva.
     * @return la promozione attiva
     */
    Promozione getPromozioneAttiva();

    int getIdImpiegato();

    void setIdImpiegato(int id);
}
