package it.unicam.ids.C3Project.MODEL;

import java.util.List;

public interface ICarrello {

    public int getCliente();

    public int getCommerciante();

    public void setCommerciante(int commerciante);

    List<IProdotto> getProdottiCarrello();

    public void addProdotto(IProdotto p);

    public void removeProdotto(IProdotto p);

    public double getTotaleCarrello();

}
