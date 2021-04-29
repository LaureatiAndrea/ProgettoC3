package it.unicam.cs.ids.c3.negozio;

import java.util.ArrayList;

public class SimpleNegozio implements Negozio{

    private String nome;
    private String indirizzo;
    private Categoria_Merceologica categoria;
    private ArrayList<Promozione> promozioni;

    public SimpleNegozio(String nome,String indirizzo,Categoria_Merceologica categoria){
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.categoria = categoria;
        promozioni = new ArrayList<>();
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
        this.promozioni.add(promozione);
    }

    @Override
    public void terminaPromozione(Promozione promozione) {
        for(Promozione p : this.promozioni){
         if(p.equals(promozione)){
             p.setStatoPromozione(false);
         }
        }
    }
}
