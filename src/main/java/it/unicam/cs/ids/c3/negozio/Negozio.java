package it.unicam.cs.ids.c3.negozio;

import java.util.ArrayList;

/**
 * Le classi che implementano questa interfaccia hanno la responsabilità di descrivere un negozio del sistema C3
 *
 * @author Laureati Andrea Francesco, Gaetani Marco
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
     * cambia la categoria merceologica venduta dal negozio
     * @param cat la nuova categoria
     */
    void setCategoria(Categoria_Merceologica cat);

    /**
     * @return la lista delle promozioni del negozio
     */
    ArrayList<Promozione> getPromozioni();

    /**
     * @param p la promozione da aggiungere
     */
    void lanciaPromozione(Promozione p);

    /**
     * @param p la promozione da rimuovere
     */
    void terminaPromozione(Promozione p);

}
