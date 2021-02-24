package it.unicam.ids.C3Project.ENTITY;

import java.time.LocalTime;

public interface IPuntoDiRitiro {


    public String getNome();

    public String getIndirizzo();

    public String getTelefono();

    public LocalTime getOrario();

    public String getEmail();

    public String getPassword();

    public void setPassword(String password);

    public int getNegozio();

    public void setNegozio(int negozio);
}

