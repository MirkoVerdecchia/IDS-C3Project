package it.unicam.ids.C3Project.ENTITY;

public interface ICorriere {

    int getID();

    String getNome();

    String getVeicolo();

    public String getEmail();

    public String getPassword();

    public void setPassword(String password);
}
