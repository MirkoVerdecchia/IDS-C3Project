package it.unicam.ids.C3Project.MODEL;

public class ContoCorrente implements IContoCorrente {
    private double saldo;
    private String IBAN;

    public ContoCorrente(double saldo, String IBAN) {
        this.saldo = saldo;
        this.IBAN = IBAN;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public String getIBAN() {
        return IBAN;
    }

    public void decreaseSaldo(double importo){
        assert saldo >= importo;
        this.saldo -= importo;
    }

    public void increaseSaldo(double importo) {
        this.saldo += importo;
    }


}
