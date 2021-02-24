package it.unicam.ids.C3Project.MODEL;


public class Acquisto implements IAcquisto {

    private int ID;
    private String nomeCliente;
    private String destinazione;
    private double totale;
    private StatoOrdine stato;


    public Acquisto(int ID, String nomeCliente, String destinazione, double totale) {
        this.ID = ID;
        this.nomeCliente = nomeCliente;
        this.destinazione = destinazione;
        this.totale = totale;
        this.stato = StatoOrdine.PREPARAZIONE;
    }



    @Override
    public int getID() {
        return ID;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public String getDestinazione() {
        return destinazione;
    }

    @Override
    public double getTotale() {
        return totale;
    }

    @Override
    public StatoOrdine getStato() {
        return stato;
    }

    @Override
    public void setStato(StatoOrdine s) {
        this.stato = s;
    }



}
