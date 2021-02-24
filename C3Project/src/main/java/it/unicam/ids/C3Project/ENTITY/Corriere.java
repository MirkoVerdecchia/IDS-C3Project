package it.unicam.ids.C3Project.ENTITY;


public class Corriere implements ICorriere {

    private int ID;
    private String nome;
    private String veicolo;
    private String email;
    private String password;

    public Corriere(int ID, String nome, String veicolo, String email, String password) {
        this.ID = ID;
        this.nome = nome;
        this.veicolo = veicolo;
        this.email = email;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getVeicolo() {
        return veicolo;
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
}
