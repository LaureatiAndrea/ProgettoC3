package it.unicam.cs.ids.c3.negozio;

public class Promozione {

    private double percentualeSconto;
    private boolean statoPromozione;

    public Promozione(double percentualeSconto){
        this.percentualeSconto = percentualeSconto;
        this.statoPromozione = true;
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
}