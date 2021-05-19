package it.unicam.cs.ids.c3.ordine;

import java.util.Random;

/**
 * Questa classe descrive un ordine del sistema C3. Un ordine ha un identificativo, dei riferimenti al cliente, negozio
 * e corriere. Ha inoltre uno stato che rappresenta lo stato di lavorazione dell'ordine ed un codice necessario per
 * il ritiro dell'ordine stesso presso il magazzino.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class SimpleOrdine implements Ordine {

    private int idOrdine;
    private int idCliente;
    private String destinazione;
    private String note;
    private int idMagazzino;
    private int idNegozio;
    private int codiceRitiro;
    private int idCorriere;
    private Stato_Ordine statoOrdine;

    public SimpleOrdine(int idOrdine, int idCliente,int idCorriere,String destinazione, int idMagazzino,int idNegozio, String note){
        this.idOrdine = idOrdine;
        this.idCliente = idCliente;
        this.idMagazzino = idMagazzino;
        this.idCorriere = idCorriere;
        this.idNegozio = idNegozio;
        this.note = note;
        this.destinazione = destinazione;
        this.statoOrdine = Stato_Ordine.IN_NEGOZIO;
        this.codiceRitiro = generaCodice();
    }

    public SimpleOrdine(int idOrdine, int idCliente, String destinazione, String note, int idMagazzino, int idNegozio,
                        int codiceRitiro, int idCorriere, String stato){
        //Costruttore utilizzato dal database.
        this.idOrdine = idOrdine;
        this.idCliente = idCliente;
        this.destinazione = destinazione;
        this.note = note;
        this.idMagazzino = idMagazzino;
        this.idNegozio = idNegozio;
        this.codiceRitiro = codiceRitiro;
        this.idCorriere = idCorriere;
        this.statoOrdine = Stato_Ordine.valueOf(stato);
    }

    /**
     * Il metodo genera un codice randomico necessario per il ritiro della merce.
     * @return il codice per ritirare la merce.
     */
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

    @Override
    public void setIdMagazzino(int id){
        this.idMagazzino = id;
    }

    @Override
    public void setIdCorriere(int id) {
        this.idCorriere = id;
    }

    @Override
    public int getIdCorriere() {
        return this.idCorriere;
    }

    @Override
    public int getIdNegozio() {
        return this.idNegozio;
    }

    @Override
    public void setIdNegozio(int idNegozio) {
        this.idNegozio = idNegozio;
    }

    @Override
    public String getNote() {
        return this.note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int getIdMagazzino(){
        return this.idMagazzino;
    }

    @Override
    public String toString() {
        return "SimpleOrdine{" +
                "idOrdine=" + idOrdine +
                ", idCliente=" + idCliente +
                ", destinazione='" + destinazione + '\'' +
                ", note='" + note + '\'' +
                ", idMagazzino=" + idMagazzino +
                ", codiceRitiro=" + codiceRitiro +
                ", idCorriere=" + idCorriere +
                ", idNegozio=" + idNegozio +
                ", statoOrdine=" + statoOrdine +
                '}';
    }
}
