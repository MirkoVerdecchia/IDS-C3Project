package it.unicam.ids.C3Project.MODEL;


public class Pagamento {

    private IContoCorrente creditore;
    private IContoCorrente debitore;
    private double importo;

    public Pagamento(IContoCorrente creditore, IContoCorrente debitore, double importo) {
        this.creditore = creditore;
        this.debitore = debitore;
        this.importo = importo;
    }

    public void paga() {
        this.debitore.decreaseSaldo(importo);
        this.creditore.increaseSaldo(importo);
    }
}
