package it.unicam.ids.C3Project.DB;



import it.unicam.ids.C3Project.ENTITY.ICliente;
import it.unicam.ids.C3Project.ENTITY.ICommerciante;
import it.unicam.ids.C3Project.ENTITY.ICorriere;
import it.unicam.ids.C3Project.MODEL.IAcquisto;
import it.unicam.ids.C3Project.MODEL.IProdotto;
import it.unicam.ids.C3Project.ENTITY.IPuntoDiRitiro;


import java.util.List;

public class Database {

    private List<IProdotto> prodotti;
    private List<IAcquisto> acquisti;
    private List<ICommerciante> commercianti;
    private List<ICliente> clienti;
    private List<ICorriere> corrieri;
    private List<IPuntoDiRitiro> puntiDiRitiro;

    public Database(List<IProdotto> prodotti, List<IAcquisto> acquisti, List<ICommerciante> commercianti, List<ICliente> clienti, List<ICorriere> corrieri, List<IPuntoDiRitiro> puntiDiRitiro) {
        this.prodotti = prodotti;
        this.acquisti = acquisti;
        this.commercianti = commercianti;
        this.clienti = clienti;
        this.corrieri = corrieri;
        this.puntiDiRitiro = puntiDiRitiro;
    }

    public List<IProdotto> getProdotti() {
        return prodotti;
    }

    public List<IAcquisto> getAcquisti() { return acquisti; }

    public List<ICommerciante> getCommercianti() {
        return commercianti;
    }

    public List<ICliente> getClienti() {
        return clienti;
    }

    public List<ICorriere> getCorrieri() {
        return corrieri;
    }

    public List<IPuntoDiRitiro> getPuntiDiRitiro() {
        return puntiDiRitiro;
    }

}
