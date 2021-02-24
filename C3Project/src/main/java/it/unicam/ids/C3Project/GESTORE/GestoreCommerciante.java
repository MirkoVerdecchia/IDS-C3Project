package it.unicam.ids.C3Project.GESTORE;

import it.unicam.ids.C3Project.DB.Database;
import it.unicam.ids.C3Project.ENTITY.ICommerciante;
import it.unicam.ids.C3Project.MODEL.IProdotto;
import it.unicam.ids.C3Project.MODEL.Prodotto;

import java.util.Scanner;

public class GestoreCommerciante {

    private ICommerciante commerciante;
    private Database database;

    public GestoreCommerciante(ICommerciante commerciante,Database database) {
        this.commerciante = commerciante;
        this.database = database;
    }


    public void menu(){
        System.out.print("---------------MENU---------------" +
                "\nScegli l'operazione da effettuare:" +
                "\n1 - Aggiungi un prodotto" +
                "\n2 - Modifica un prodotto" +
                "\n3 - Rimuovere un prodotto" +
                "\n4 - Modifica password");
        Scanner tastiera0 = new Scanner(System.in);
        int n = tastiera0.nextInt();
        if  ( n == 1 ){
            addProdotto();
        } else if (n == 2) {
            modificaProdotto();
        } else if (n == 3){
            removeProdotto();
        } else if (n == 4){
            cambiaPassword();
        } else {
            System.out.println("Digita un numero da 1 a 4!!");
            menu();
        }


    }



    public void addProdotto() {
        int newCodice = database.getProdotti().size();
        Scanner tastiera = new Scanner(System.in);
        System.out.println("\nInserire i dettagli del prodotto da inserire:");
        System.out.println("\nNome -");
        String name = tastiera.next();
        System.out.println("\nDescizione -");
        String desc = tastiera.next();
        System.out.println("\nQuantità - ");
        int qta = tastiera.nextInt();
        System.out.println("\nPrezzo - ");
        double prez = tastiera.nextDouble();
        database.getProdotti().add((IProdotto) new Prodotto(newCodice, name, desc, qta, prez,this.commerciante));
        System.out.print(database.getProdotti().indexOf(newCodice));

    }

    public void modificaProdotto() {
        String nome = null;
        Scanner tastiera = new Scanner(System.in);
        System.out.print("\nInserisci il nome del Prodotto che vuoi modificare:");
        String n = tastiera.next();
        String name = n;
        if (!database.getProdotti().contains(name)) {
            System.out.print("\n^^^Il prodotto inserito non esiste^^^");
        } else {
            System.out.print("\nCosa vuoi modificare? Inserisci il numero a seconda della scelta" +
                    "\n1 - Nome" +
                    "\n2 - Descrizione" +
                    "\n3 - Quantità" +
                    "\n4 - Prezzo");
            int x = tastiera.nextInt();
            if (x == 1) {
                for (IProdotto p: database.getProdotti()) {
                    if (p.getNome() == name) {
                        System.out.print("\n Inserisci il nuovo nome:");
                        String nuovoNome = tastiera.next();
                        p.setNome(nuovoNome);
                    }
                }
            } else if (x == 2) {
                for (IProdotto p: database.getProdotti()) {
                    if (p.getNome() == name) {
                        System.out.print("\n Inserisci la nuova descrizione:");
                        String nuovaDescrizione = tastiera.next();
                        p.setDescrizione(nuovaDescrizione);
                    }
                }
            } else if (x == 3) {
                for (IProdotto p: database.getProdotti()) {
                    if (p.getNome() == name) {
                        System.out.print("\n Inserisci la nuova quantità:");
                        int nuovaQuantita = tastiera.nextInt();
                        p.setQuantita(nuovaQuantita);
                    }
                }
            } else if (x == 4) {
                for (IProdotto p: database.getProdotti()) {
                    if (p.getNome() == name) {
                        System.out.print("\n Inserisci il nuovo prezzo:");
                        int nuovoPrezzo = tastiera.nextInt();
                        p.setPrezzo(nuovoPrezzo);
                    }
                }
            }
        }
    }


    public void removeProdotto(){
        Scanner tastiera = new Scanner(System.in);
        System.out.print("\nInserisci il nome del Prodotto che vuoi eliminare:");
        String n = tastiera.next();
        for(IProdotto p : database.getProdotti()) {
            if( p.getNome().equals(n)){
                System.out.println("Digitare 1 se uoi davvero eliminare\n" +
                        p.toString() +
                        "\nDigitare 0 altrimenti");
                int r = tastiera.nextInt();
                if (r == 1){
                    database.getProdotti().remove(p);
                    System.out.println("Prodotto eliminato dal database");
                } else if(r == 0) {
                    menu();
                } else{
                    System.out.println("Inserisci un  numero valido!! " +
                            "\n1 o 0!");
                }

            }

        }

    }

    private void cambiaPassword() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire la nuova password:");
        String newPass = tastiera.next();
        commerciante.setPassword(newPass);
        System.out.println("Password cambiata con successo!");
        menu();
    }






}
