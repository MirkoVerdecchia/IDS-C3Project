package it.unicam.ids.C3Project.MODEL;

import it.unicam.ids.C3Project.ENTITY.ICommerciante;

public class Prodotto implements IProdotto {

    private int codice;
    private String nome;
    private String descrizione;
    private int quantita;
    private double prezzo;
    private ICommerciante commerciante;


    public Prodotto(String nome, String descrizione, int quantita, double prezzo, ICommerciante commerciante) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.commerciante = commerciante;

    }

    public Prodotto(int codice, String nome, String descrizione, int quantita, double prezzo, ICommerciante commerciante) {
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.commerciante = commerciante;

    }

    @Override
    public int getCodice() {
        return codice;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public int getQuantita() {
        return quantita;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public ICommerciante getCommerciante() {
        return commerciante;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public void setQuantita(int disponibilita) {
        this.quantita = disponibilita;
    }

    @Override
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
