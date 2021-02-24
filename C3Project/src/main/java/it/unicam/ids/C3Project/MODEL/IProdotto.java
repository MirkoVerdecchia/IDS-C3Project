package it.unicam.ids.C3Project.MODEL;

import it.unicam.ids.C3Project.ENTITY.ICommerciante;

public interface IProdotto {

    public int getCodice();

    public String getNome();

    public String getDescrizione();

    public int getQuantita();

    public double getPrezzo();

    ICommerciante getCommerciante();

    void setNome(String nome);

    void setDescrizione(String descrizione);

    void setQuantita(int disponibilita);

    void setPrezzo(double prezzo);
}
