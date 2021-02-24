package it.unicam.ids.C3Project.ENTITY;

import java.time.LocalTime;

public class PuntoDiRitiro implements IPuntoDiRitiro {

    private String nome;
    private String indirizzo;
    private LocalTime orario;
    private String telefono;
    private String email;
    private String password;
    private int negozio;

    public PuntoDiRitiro(String nome, String indirizzo, LocalTime orario, String telefono, String email, String password, int negozio) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.orario = orario;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.negozio = negozio;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalTime getOrario() {
        return orario;
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

    public int getNegozio() {
        return negozio;
    }

    public void setNegozio(int negozio) {
        this.negozio = negozio;
    }
}