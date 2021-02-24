package it.unicam.ids.C3Project.ENTITY;

import it.unicam.ids.C3Project.MODEL.ICarrello;
import it.unicam.ids.C3Project.MODEL.Carrello;
import it.unicam.ids.C3Project.MODEL.IContoCorrente;

public class Cliente implements ICliente {

    private int ID;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String email;
    private String password;
    private IContoCorrente contoCorrente;
    private ICarrello carrello;

    public Cliente(int ID, String nome, String cognome, String indirizzo, String email,String password, IContoCorrente contoCorrente) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;

        this. email = email;
        this.password = password;
        this.contoCorrente = contoCorrente;

        carrello = new Carrello(ID);
    }


    public Cliente(int ID, String nome, String cognome, String indirizzo, String email,ICarrello carrello, IContoCorrente contoCorrente) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;

        this. email = email;
        this.contoCorrente = contoCorrente;


        this.carrello = carrello;

    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
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

    public IContoCorrente getContoCorrente() {
        return contoCorrente;
    }

    public ICarrello getCarrello(){
        return carrello;
    }

    public int getIDNegozioProdotti(){
        return carrello.getCommerciante();
    }


}
