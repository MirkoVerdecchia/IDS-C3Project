package it.unicam.ids.C3Project.ENTITY;

import it.unicam.ids.C3Project.MODEL.IContoCorrente;

public interface ICommerciante {

    int getID();

    String getNome();

    public String getEmail();

    public String getPassword();

    public void setPassword(String password);

    public String getNomeNegozio();

    public String getCittaNegozio();

    public IContoCorrente getContoCorrente();

}
