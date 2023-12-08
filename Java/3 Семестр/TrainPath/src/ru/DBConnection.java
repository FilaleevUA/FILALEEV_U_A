package ru;

import java.sql.*;
import java.util.Objects;

public class DBConnection {
    private String url = "jdbc:mysql://localhost:3306/TrainPath";
    private String username = "root";
    private String password = "root";

    public void ConnectionDB(String url,String username,String  password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void ConnectionDB() {}


    public String getTableRoute(){
        StringBuilder tableRoute = new StringBuilder();
        try {
            try (Connection con = DriverManager.getConnection(url, username, password)){
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM route");
                    while (resultSet.next()){
                        int id = resultSet.getInt("ID");
                        String nameRoute = resultSet.getString("NameRoute");
                        int numberTrain = resultSet.getInt("NumberTrain");
                        tableRoute.append(id).append(" ");
                        tableRoute.append(nameRoute).append(" ");
                        tableRoute.append(numberTrain).append(" \n");
                    }
            }

        }catch (Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return tableRoute.toString();
    }

    public void writeNewRoute (String nameRoute, int numberTrain){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("INSERT route(NameRoute, NumberTrain) VALUES ('" + nameRoute + "', " + numberTrain + ")");
            System.out.println("Added 1 rows");

        } catch (Exception ex) {
            System.out.println("Connection failed...");

        }
    }

    public void deleteRoute(String nameRoute){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            String table = getTableRoute();
            int i = 0;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM route");
            while (resultSet.next()){
                if (Objects.equals(resultSet.getString("NameRoute"), nameRoute)){
                    int id = resultSet.getInt("ID");
                    int rows = statement.executeUpdate("DELETE FROM route WHERE Id = " + id);
                    System.out.printf("%d row deleted ", rows);
                    return;

                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
    }

}
