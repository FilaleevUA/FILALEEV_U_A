package ru;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private String url = "\"jdbc:mysql://localhost:3306/TrainPath\"";
    private String username = "root";
    private String password = "root";

    public void ConnectionDB(String url,String username,String  password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void ConnectionDB() {}

    public void connectionDataBase() {
        try{
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                System.out.println("Connection to TrainPath DB succesfull!");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public void CreateNewTableDB(){}

    public void writeToTable(){

    }
}
