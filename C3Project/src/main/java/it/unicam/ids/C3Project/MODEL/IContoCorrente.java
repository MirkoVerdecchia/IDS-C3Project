package it.unicam.ids.C3Project.MODEL;

public interface IContoCorrente {


    double getSaldo();

    String getIBAN();

    public void decreaseSaldo(double importo);

    public void increaseSaldo(double importo);


}


