package it.unicam.ids.C3Project.MODEL;

import java.util.ArrayList;
import java.util.List;

public class Carrello implements ICarrello {

    private int cliente;
    private int commerciante;
    private List<IProdotto> prodottiCarrello;



    public Carrello(int cliente) {
        this.cliente = cliente;
        prodottiCarrello = new ArrayList();

    }




    public int getCliente() {
        return cliente;
    }

    public int getCommerciante() {
        return commerciante;
    }

    public void setCommerciante(int commerciante) {
        this.commerciante = commerciante;
    }

    public List<IProdotto> getProdottiCarrello() {
        return prodottiCarrello;
    }



    public void addProdotto(IProdotto p ) {
        prodottiCarrello.add(p);
    }


    public void removeProdotto(IProdotto p){
        prodottiCarrello.remove(p);
    }


    public double getTotaleCarrello(){
        double totale = 0;
        for (int i=0; i<prodottiCarrello.size(); i++)
        {
            IProdotto prodotto = prodottiCarrello.get(i);
            totale = totale + prodotto.getPrezzo();
        }
        return totale ;
    }









}