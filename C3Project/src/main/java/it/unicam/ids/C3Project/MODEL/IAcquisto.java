package it.unicam.ids.C3Project.MODEL;

import it.unicam.ids.C3Project.ENTITY.ICliente;
import it.unicam.ids.C3Project.MODEL.StatoOrdine;

public interface IAcquisto {

    public String getNomeCliente();

    public int getID();

    public String getDestinazione();

    public double getTotale();

    public StatoOrdine getStato();

    public void setStato(StatoOrdine stato);

    }
