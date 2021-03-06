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
    private boolean promozioneAttiva;
    private String note;

    public Promozione(int id, double percentualeSconto, String note){
        this.idPromozione = id;
        this.percentualeSconto = percentualeSconto;
        this.promozioneAttiva = true;
        this.note = note;
    }

    public Promozione(int id, double percentualeSconto, int promozioneAttiva, String note) {
        this.idPromozione = id;
        this.percentualeSconto = percentualeSconto;
        if(promozioneAttiva==0){
            this.promozioneAttiva =  false;
        }else this.promozioneAttiva = true;
        this.note = note;
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
        return this.promozioneAttiva;
    }

    public void setStatoPromozione(boolean statoPromozione){
        this.promozioneAttiva = statoPromozione;
    }

    @Override
    public String toString() {
        return "Promozione{" +
                "idPromozione=" + idPromozione +
                ", percentualeSconto=" + percentualeSconto +
                ", statoPromozione=" + promozioneAttiva +
                '}';
    }

    public String getNote() {
        return this.note;
    }
}