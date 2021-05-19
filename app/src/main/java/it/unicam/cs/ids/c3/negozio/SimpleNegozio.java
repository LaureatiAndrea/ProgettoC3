package it.unicam.cs.ids.c3.negozio;

import java.util.ArrayList;

/**
 * Questa classe ha la responsabilitá di descrivere un negozio del sistema C3. Un negozio ha un identificativo , un nome,
 * un indirizzo ed una categoria merceologica. Contiene inoltre una lista delle promozioni relative al negozio.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class SimpleNegozio implements Negozio{

    private int id;
    private String nome;
    private String indirizzo;
    private Categoria_Merceologica categoria;
    private ArrayList<Promozione> promozioni;
    private int idImpiegato;

    public SimpleNegozio(int id,String nome,String indirizzo,Categoria_Merceologica categoria, int idImpiegato){
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.categoria = categoria;
        this.idImpiegato = idImpiegato;
        promozioni = new ArrayList<>();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getIndirizzo() {
        return this.indirizzo;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public Categoria_Merceologica getCategoria() {
        return this.categoria;
    }

    @Override
    public void setCategoria(Categoria_Merceologica categoria) {
        this.categoria = categoria;
    }

    @Override
    public ArrayList<Promozione> getPromozioni() {
        return this.promozioni;
    }

    @Override
    public void lanciaPromozione(Promozione promozione) {
        for(Promozione p : this.promozioni){
            if(p.equals(promozione)){
                p.setStatoPromozione(true);
            }
        }
    }

    @Override
    public void terminaPromozione(Promozione promozione) {
        for(Promozione p : this.promozioni){
         if(p.equals(promozione)){
             p.setStatoPromozione(false);
         }
        }
    }

    @Override
    public Promozione getPromozione(int id) {
        for(Promozione p : this.promozioni){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void addPromozione(Promozione p) {
        this.promozioni.add(p);
    }

    @Override
    public void removePromozione(Promozione p) {
        this.promozioni.remove(p);
    }
}
