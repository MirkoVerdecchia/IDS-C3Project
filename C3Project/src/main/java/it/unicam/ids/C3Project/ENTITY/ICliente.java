package it.unicam.ids.C3Project.ENTITY;

import it.unicam.ids.C3Project.MODEL.ICarrello;
import it.unicam.ids.C3Project.MODEL.IContoCorrente;

public interface ICliente {

    public int getID();

    public String getNome();

    public String getCognome();

    public String getIndirizzo();

    public String getEmail();

    public String getPassword();

    public void setPassword(String password);

    public IContoCorrente getContoCorrente();

    public ICarrello getCarrello();

    public int getIDNegozioProdotti();
}
