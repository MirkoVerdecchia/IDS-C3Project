package it.unicam.ids.C3Project.GESTORE;

import it.unicam.ids.C3Project.DB.Database;
import it.unicam.ids.C3Project.ENTITY.ICliente;
import it.unicam.ids.C3Project.ENTITY.ICommerciante;
import it.unicam.ids.C3Project.ENTITY.ICorriere;
import it.unicam.ids.C3Project.ENTITY.IPuntoDiRitiro;

import java.util.Scanner;

public class InteractionMenager {

    private ICommerciante commerciante;
    private ICliente cliente;
    private ICorriere corriere;
    private IPuntoDiRitiro puntoDiRitiro;
    private static Database database;


    public void startC3(Scanner reader) {
        System.out.print("\n\n\n\n ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" +
                "\n BENVETUTO NELL'APP C3" +
                "\n Scegli con quale account entrare: " +
                "\n 1 - Commerciante" +
                "\n 2 - Corriere" +
                "\n 3 - Cliente" +
                "\n 4 - Punto Di Ritiro");
        Scanner tastiera = new Scanner(System.in);
        int n = tastiera.nextInt();
        if  ( n == 1 ){
            menuCommerciante();
        }else if (n == 2){
            menuCorriere();
        }else if (n == 3){
            menuCliente();
        }else if (n == 4){
            menuPuntoDiRitiro();
        }else {
            System.out.print("Numero non valido, scegliere da 1 a 4!!");
        }

    }


    public static void menuCommerciante() {
        GestoreCommerciante commerciante = null;
        Scanner tastiera = new Scanner(System.in);
        System.out.print("inserisci un'email:");
        String email = tastiera.nextLine();
        System.out.print("inserisci la password:");
        String password = tastiera.nextLine();
        for (ICommerciante c : database.getCommercianti()) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                commerciante = new GestoreCommerciante(c, database);
                commerciante.menu();
            }else{
                System.out.println("Email o Password errata..." +
                        "\nRiprovare");
                menuCommerciante();
            }
        }
    }



    public static void menuCorriere(){
        GestoreCorriere corriere = null;
        Scanner tastiera = new Scanner(System.in);
        System.out.print("inserisci un'email:");
        String email = tastiera.nextLine();
        System.out.print("inserisci la password:");
        String password = tastiera.nextLine();
        for (ICorriere c : database.getCorrieri()) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                corriere = new GestoreCorriere(c, database);
                corriere.menu();
            }else{
                System.out.println("Email o Password errata..." +
                        "\nRiprovare");
                menuCorriere();
            }
        }
    }




    public static void menuCliente() {
        GestoreCliente cliente = null;
        Scanner tastiera = new Scanner(System.in);
        System.out.print("Inserisci la tua email:");
        String email= tastiera.nextLine();
        System.out.print("Inserisci la tua password:");
        String password= tastiera.nextLine();
        for(ICliente c : database.getClienti()){
            if(c.getEmail().equals(email) && c.getPassword().equals(password)){
                cliente = new GestoreCliente(c,database);
                cliente.menu();
            }else{
                System.out.println("Email o Password errata... " +
                        "\nRiprovare");
                menuCliente();
            }
        }
    }




    public static void menuPuntoDiRitiro() {
        GestorePuntoDiRitiro puntoDiRitiro = null;
        Scanner tastiera = new Scanner(System.in);
        System.out.print("Inserisci la tua email:");
        String email= tastiera.nextLine();
        System.out.print("Inserisci la tua password:");
        String password= tastiera.nextLine();
        for(IPuntoDiRitiro pdp : database.getPuntiDiRitiro()){
            if(pdp.getEmail().equals(email) && pdp.getPassword().equals(password)){
                puntoDiRitiro = new GestorePuntoDiRitiro(pdp,database);
                puntoDiRitiro.menu();
            }else{
                System.out.println("Email o Password errata... " +
                        "\nRiprovare");
                menuPuntoDiRitiro();
            }
        }
    }


}

