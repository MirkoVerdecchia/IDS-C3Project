package it.unicam.ids.C3Project.ENTITY;

import it.unicam.ids.C3Project.MODEL.IContoCorrente;

public class Commerciante implements ICommerciante {

    private int ID;
    private String nome;
    private String email;
    private String password;
    private String nomeNegozio;
    private String cittaNegozio;

    private IContoCorrente contoCorrente;


    public Commerciante(int ID, String nome, String email, String password, String nomeNegozio, String cittaNegozio, IContoCorrente contoCorrente) {
        this.ID = ID;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.nomeNegozio = nomeNegozio;
        this.cittaNegozio = cittaNegozio;
        this.contoCorrente = contoCorrente;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public String getCittaNegozio() {
        return cittaNegozio;
    }

    public IContoCorrente getContoCorrente() {
        return contoCorrente;
    }
}
