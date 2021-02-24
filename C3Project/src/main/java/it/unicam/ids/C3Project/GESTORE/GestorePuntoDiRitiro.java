package it.unicam.ids.C3Project.GESTORE;

import it.unicam.ids.C3Project.DB.Database;
import it.unicam.ids.C3Project.ENTITY.ICommerciante;
import it.unicam.ids.C3Project.ENTITY.IPuntoDiRitiro;

import java.util.Scanner;

public class GestorePuntoDiRitiro {
    IPuntoDiRitiro puntoDiRitiro;
    Database database;

    public GestorePuntoDiRitiro(IPuntoDiRitiro puntoDiRitiro, Database database) {
        this.puntoDiRitiro = puntoDiRitiro;
        this.database = database;
    }

    public void menu() {
        System.out.println("---------------MENU---------------" +
                "\nScegli l'operazione da effettuare:" +
                "\n1 - Associati ad un negozio");
        Scanner tastiera1 = new Scanner(System.in);
        int n = tastiera1.nextInt();
        if (n == 1) {
            associaNegozio();
        } else if (n == 2) {
            cambiaPassword();
        } else {
            System.out.println("Digita un numero da 1 a 2!!");
            menu();
        }
    }

    private void associaNegozio() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Digita il Codice del negozio al quale vuopi associarti:");
        int codiceN = tastiera.nextInt();
        for(ICommerciante c : database.getCommercianti()){
            if(c.getID() == codiceN){
                puntoDiRitiro.setNegozio(codiceN);
            }
        }
    }

    private void cambiaPassword() {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire la nuova password:");
        String newPass = tastiera.next();
        puntoDiRitiro.setPassword(newPass);
        System.out.println("Password cambiata con successo!");
        menu();
    }
}
