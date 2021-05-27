package it.unicam.cs.ids.c3.negozio;


/**
 * Questa classe descrive una promozione appartenente ad un determinato negozio. Ogni promozione  ha una
 * percentuale di sconto , ed uno stato ( Attiva, Non attiva ).
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class Promozione {

    private int idPromozione;
    private double percentualeSconto;
    //TODO : Cambiare in PROMOZIONE ATTIVA
    private boolean statoPromozione;

    public Promozione(int id, double percentualeSconto){
        this.idPromozione = id;
        this.percentualeSconto = percentualeSconto;
        this.statoPromozione = true;
    }

    public Promozione(int id, double percentualeSconto, int promozioneAttiva) {
        this.idPromozione = id;
        this.percentualeSconto = percentualeSconto;
        if(promozioneAttiva==0){
            statoPromozione =  false;
        }else statoPromozione = true;
    }

    public int getId(){
        return this.idPromozione;
    }

    public void setId(int id){
        this.idPromozione = id;
    }

    public double getPercentualeSconto() {
        return percentualeSconto;
    }

    public void setPercentualeSconto(double percentualeSconto){
        this.percentualeSconto = percentualeSconto;
    }

    public boolean getStatoPromozione(){
        return this.statoPromozione;
    }

    public void setStatoPromozione(boolean statoPromozione){
        this.statoPromozione = statoPromozione;
    }

    @Override
    public String toString() {
        return "Promozione{" +
                "idPromozione=" + idPromozione +
                ", percentualeSconto=" + percentualeSconto +
                ", statoPromozione=" + statoPromozione +
                '}';
    }
}