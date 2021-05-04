package it.unicam.cs.ids.c3.ordine;

import java.util.Random;

public class SimpleOrdine implements Ordine {

    private int idOrdine;
    private int idCliente;
    private String destinazione;
    private int codiceRitiro;
    private int idCorriere;
    private Stato_Ordine statoOrdine;

    public SimpleOrdine(int idCliente,int idCorriere,String destinazione){
        this.idCliente = idCliente;
        this.idCorriere = idCorriere;
        this.destinazione = destinazione;
        this.statoOrdine = Stato_Ordine.IN_NEGOZIO;
        this.codiceRitiro = generaCodice();
    }

    private int generaCodice() {
        Random random = new Random();
        return random.nextInt(10000);
    }

    @Override
    public int getID() {
        return this.idOrdine;
    }

    @Override
    public void setId(int id) {
        this.idOrdine = id;
    }

    @Override
    public int getIdCliente() {
        return this.idCliente;
    }

    @Override
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String getDestinazione() {
        return this.destinazione;
    }

    @Override
    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    @Override
    public int getCodiceRitiro() {
        return this.codiceRitiro;
    }

    @Override
    public void setCodiceRitiro(int codiceRitiro) {
        this.codiceRitiro = codiceRitiro;
    }

    @Override
    public Stato_Ordine getStatoOrdine() {
        return this.statoOrdine;
    }

    @Override
    public void setStatoOrdine(Stato_Ordine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }
}
