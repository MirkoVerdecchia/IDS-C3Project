package it.unicam.ids.C3Project.GESTORE;

import it.unicam.ids.C3Project.DB.Database;
import it.unicam.ids.C3Project.MODEL.IAcquisto;
import it.unicam.ids.C3Project.ENTITY.ICorriere;
import it.unicam.ids.C3Project.MODEL.StatoOrdine;

import java.util.Scanner;


public class GestoreCorriere {
    private ICorriere corriere;
    private Database database;



    public GestoreCorriere(ICorriere corriere,Database database) {
        this.corriere = corriere;
        this.database = database;
    }


    public void menu(){
        System.out.println("---------------MENU---------------" +
                "\nScegli l'operazione da effettuare:" +
                "\n1 - Vedi dettagli consegna" +
                "\n2 - Aggiorna stato ordine" +
                "\n3 - Cambia Password");
        Scanner tastiera1 = new Scanner(System.in);
        int n = tastiera1.nextInt();
        if (n == 1) {
            dettagliConsegna();
        } else if ( n == 2) {
            aggiornaStatoOrdine();
        } else if ( n == 3){
            cambiaPassword();
        } else {
            System.out.println("Digita un numero da 1 a 3!!");
            menu();
        }
    }


    public void aggiornaStatoOrdine() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Aggiorna lo stato dell'ordine,");
        System.out.println("Digita l'ID dell'acquisto che vuoi aggiornare:");
        int ID = tastiera.nextInt();
        for(IAcquisto a : database.getAcquisti()) {
            if (a.getID() == ID) {
                System.out.println("inserisci:\n" +
                        "1- impostare l'ordine in stato di preparazione\n" +
                        "2- impostare l'ordine in stato di consegna\n" +
                        "3- nel caso in cui l'ordine è stato consegnato");
                int s = tastiera.nextInt();
                switch (s) {
                    case 1:
                        a.setStato(StatoOrdine.PREPARAZIONE);
                        System.out.println("Stato aggiornato 'PREPARAZIONE'");
                        break;
                    case 2:
                        a.setStato(StatoOrdine.SPEDITO);
                        System.out.println("Stato aggiornato 'SPEDITO'");
                        break;
                    case 3:
                        a.setStato(StatoOrdine.CONSEGNATO);
                        System.out.println("Stato aggiornato 'COSNEGNATO'");
                        break;
                }
            }
        }
    }





    public void dettagliConsegna() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Per visualizzare i dettagli dell'ordine");
        System.out.println("\nDigita l'ID dell'acquisto che vuoi visualizzare:");
        int ID = tastiera.nextInt();
        for (IAcquisto a : database.getAcquisti()) {
            if (a.getID() == ID) {
                System.out.println(a.toString());
            }
        }
    }


    private void cambiaPassword() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire la nuova password:");
        String newPass = tastiera.next();
        corriere.setPassword(newPass);
        System.out.println("Password cambiata con successo!");
        menu();
    }






}
