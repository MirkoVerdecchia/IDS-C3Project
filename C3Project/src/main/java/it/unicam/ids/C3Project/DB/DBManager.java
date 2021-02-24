package it.unicam.ids.C3Project.DB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance;
    private String url;
    private String user;
    private String psw;
    private Connection conn = null;


    private DBManager(){

    }

    public void setDBManager (String url, String user, String psw){
        this.url = url;
        this.user = user;
        this.psw = psw;
    }

    public static DBManager getInstance(){
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }


    private void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("where is your sqlJDBC Driver?" + "Include in your library path!");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, user, psw);
            System.out.println("Database connected, ready to go!");
        } catch (SQLException e) {
            System.out.println("problems in opening a connection to the database");
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Problems in closing the connection to the DB");
            e.printStackTrace();
        }
    }

    public boolean DBtest() {
        Boolean result = true;
        try {
            if (conn == null || !conn.isClosed()) {
                connect();
                result = false;
            }
            DatabaseMetaData data = conn.getMetaData();
            System.out.println("Details on DBMS - " + data.getDatabaseProductName() + "\n" + "  version:  "
                    + data.getDriverMajorVersion() + "\n" + "  catalogs: " + data.getCatalogs().getCursorName() + "\n"
                    + "  schemas:  " + data.getSchemas().getRow() + "\n");
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
