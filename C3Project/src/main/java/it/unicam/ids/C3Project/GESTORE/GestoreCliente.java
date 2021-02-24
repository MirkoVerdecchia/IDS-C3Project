package it.unicam.ids.C3Project.GESTORE;

import it.unicam.ids.C3Project.DB.Database;
import it.unicam.ids.C3Project.ENTITY.ICliente;
import it.unicam.ids.C3Project.ENTITY.ICommerciante;
import it.unicam.ids.C3Project.ENTITY.IPuntoDiRitiro;
import it.unicam.ids.C3Project.MODEL.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestoreCliente {

    private ICliente cliente;
    private Database database;




    public GestoreCliente(ICliente cliente, Database database) {
        this.cliente = cliente;
        this.database = database;
    }

    public void menu(){
        System.out.println("---------------MENU---------------" +
                "\nScegli l'operazione da effettuare:" +
                "\n1 - Cerca negozio per vederne i prodotti" +
                "\n2 - Visualizzare il totale del tuo carrello ed eventualmente fare l'acquisto" +
                "\n3 - Cambiare password ");
        Scanner tastiera = new Scanner(System.in);
        int y = tastiera.nextInt();
        if (y == 1) {
            cercaNegozio();
        } else if (y == 2) {
            visualizzaCarrello();
        } else if (y == 3) {
            cambiaPassword();
        } else {
            System.out.println("Digita un numero da 1 a 3!!");
            menu();
        }
    }


    public void cercaNegozio() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Vuoi cercare un negozio per il suo nome o per la sua città?" +
                "\n digita:" +
                "1- per cercarlo per nome " +
                "2- per cercarlo per la città");
        int r = tastiera.nextInt();
        if( r == 1) {
            System.out.println("Digita il nome del negozio che vuoi cercare:");
            String nome = tastiera.next();
            for (ICommerciante c: database.getCommercianti()) {
                if (c.getNomeNegozio().equals(nome)) {
                    System.out.println(c.toString());
                    visualizzaProdotti(c);
                }
            }
        } else {
            ICommerciante commerciante = null;
            System.out.println("Digita la città dove cercare i negozi:");
            String citta = tastiera.next();
            for (ICommerciante c: database.getCommercianti()) {
                if (c.getCittaNegozio().equals(citta)) {
                    System.out.println(c.toString());
                    System.out.println("Digita il nome del negozio che vuoi visualizzarne i prodotti:");
                    String nome = tastiera.next();
                    for (ICommerciante co: database.getCommercianti()) {
                        if (co.getNomeNegozio().equals(nome)) {
                            visualizzaProdotti(co);

                        }
                    }
                }
            }
        }

    }



    public void visualizzaProdotti(ICommerciante commerciante){
        Scanner tastiera = new Scanner(System.in);
        for( IProdotto p : database.getProdotti()){
            if  ( p.getCommerciante().equals(commerciante)){
                System.out.println("codice: " + p.getCodice() + "prodotto: " + p.toString());
            }
        }
        System.out.println("Vuoi inserire dei prodotti nel tuo carrello?" +
                "\n Digita 1 per dire si" +
                "\n Digita 2 per tornare a cercare un negozio.");
        int risposta = tastiera.nextInt();
        if (risposta == 1){
            inserisciProdottoCarrello(commerciante);
        }
    }

    public void acquistaMerce(double totaleCarrello){
        Scanner tastiera = new Scanner(System.in);
        System.out.println("\nInserire i dati per completare l'ordine:");
        System.out.println("\nInserire il nome da associare all'acquisto:");
        String nome = tastiera.next();
        System.out.println("\nDestinazione:" +
                "\nDigitare 1 se desidera ricevere la merce nel proprio domicilio " +
                "\nDigitare 2 se desidere ritirare la merce in uno dei nostri punti di ritiro");
        String destination = null;
        int n = tastiera.nextInt();
        if (n == 1) {
            System.out.println("\nInserire la città di residenza:");
            String citta = tastiera.next();
            System.out.println("\nInserire la via di residenza:");
            String via = tastiera.next();
            System.out.println("\nInserire il n. civico di residenza:");
            int nc = tastiera.nextInt();
            System.out.println("\nInserire la provincia di residenza:");
            String prov = tastiera.next();
            destination = "citta" + "via" + "nc" + "prov";
        } else if (n == 2) {
            List<IPuntoDiRitiro> pdp = new ArrayList<>();
            System.out.println("questi sono i Punti di ritiro disponibili:");
            for (IPuntoDiRitiro p: database.getPuntiDiRitiro()) {
                if(p.getNegozio() == cliente.getCarrello().getCommerciante()){
                    System.out.println(p.toString());
                    pdp.add(p);
                    
                }
            }
            System.out.println("\nScegli uno dei nostri punti di ritiro" +
                    "\ndigitando il suo nome:");
            String nomeP = tastiera.next();
            for (IPuntoDiRitiro p: pdp) {
                if (p.getNome() == nomeP) {
                    destination = p.toString();
                }else {
                    System.out.println("\nInserire un nome valido!!!");
                }
            }
        }
        int newId = database.getProdotti().size();
        database.getAcquisti().add((IAcquisto) new Acquisto(newId, nome, destination, totaleCarrello));
        System.out.print(database.getAcquisti().indexOf(newId));
        cliente.getContoCorrente().decreaseSaldo(totaleCarrello);
        menu();
    }


    public void visualizzaCarrello() {
        double totaleCarrello;
        totaleCarrello = cliente.getCarrello().getTotaleCarrello();
        Scanner tastiera = new Scanner(System.in);
        for (IProdotto p : cliente.getCarrello().getProdottiCarrello()) {
            System.out.println(p.toString());
        }
        System.out.println("Il totale del tuo carrello é:"+ totaleCarrello);
        System.out.println("Digita: " +
                "1- Se vuoi rimuove un prodotto dal tuo carrello" +
                "2- Se desideri procedere con l'acquisto");
        int r = tastiera.nextInt();
        if (r == 1) {
            rimuoviProdottoCarrello();
        } else if (r == 2){
            acquistaMerce(totaleCarrello);
        } else {
        menu();
        }
    }



    public void inserisciProdottoCarrello(ICommerciante commerciante){
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Digita il codice del prodotto che vuoi inserire nel carrello:");
        int codiceP = tastiera.nextInt();
        List<IProdotto> prodotti = new ArrayList<>();
        for(IProdotto p : database.getProdotti()) {
            if( p.getCommerciante().equals(commerciante)) {
                prodotti.add(p);
                if (prodotti.contains(p.getCodice() == codiceP)) {
                    cliente.getCarrello().setCommerciante(commerciante.getID());
                    cliente.getCarrello().addProdotto(p);
                }

            }
        }
        visualizzaProdotti(commerciante);
    }



    public void rimuoviProdottoCarrello(){
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Digita il nome del prodotto da rimuovere:");
        String nome = tastiera.next();
        for (IProdotto p : cliente.getCarrello().getProdottiCarrello()){
            if( p.getNome().equals(nome));
            cliente.getCarrello().removeProdotto(p);
        }
        visualizzaCarrello();
    }



    private void cambiaPassword() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire la nuova password:");
        String newPass = tastiera.next();
        cliente.setPassword(newPass);
        System.out.println("Password cambiata con successo!");
        menu();
    }


}
