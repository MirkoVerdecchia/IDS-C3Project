package it.unicam.ids.C3Project;


import it.unicam.ids.C3Project.DB.Database;
import it.unicam.ids.C3Project.DB.DBManager;
import it.unicam.ids.C3Project.GESTORE.InteractionMenager;

import java.util.Scanner;

public class Main {

    private static Database database;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        setC3(reader);

        InteractionMenager IM = new InteractionMenager();
        IM.startC3(reader);
    }

    public static void setC3(Scanner reader){
        System.out.println("[INFO]: Avvio app C3...");
        DBManager dbManager = DBManager.getInstance();
        dbManager.setDBManager("jdbc:mysql://localhost:3306/c3", "MAC3","4EthKsPzJl1wXIi0");
        dbManager.DBtest();
    }



}