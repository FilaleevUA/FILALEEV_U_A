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

    public void ConnectionDB() {

    }

    public void createTableRoute(){
        String sqlCommand = "CREATE TABLE route (Id INT PRIMARY KEY AUTO_INCREMENT, NameRoute VARCHAR(20), NumberTrain INT)";

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlCommand);

            System.out.println("Database has been created!");
        }catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public void createTableRoutePath(){
        String sqlCommand = "CREATE TABLE routePath (Id INT PRIMARY KEY AUTO_INCREMENT, NamePoint VARCHAR(30), TimeArrivals VARCHAR(20), TimeDepartures VARCHAR(20), NumberTrain INT)";

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlCommand);

            System.out.println("Database has been created!");
        }catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public String getTableRoutePath(int NumberTrain){
        StringBuilder tableRoute = new StringBuilder();
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM routePath");
            while (resultSet.next()) {
                if (Objects.equals(resultSet.getInt("NumberTrain"),NumberTrain)){
                    int id = resultSet.getInt("ID");
                    String nameRoute = resultSet.getString("NamePoint");
                    String timeArrivals = resultSet.getString("TimeArrivals");
                    String timeDepartures = resultSet.getString("TimeDepartures");
                    int numberTrain = resultSet.getInt("NumberTrain");
                    tableRoute.append("\t");
                    tableRoute.append(nameRoute).append(" ");
                    tableRoute.append(timeArrivals).append(" ");
                    tableRoute.append(timeDepartures).append(" ").append(" \n");
                }


            }
        }catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
        if (tableRoute.isEmpty()){
            return "An error occurred, the table was not displayed";
        }else {
            return tableRoute.toString();
        }
    }

    public String getTable(String nameTable){
        StringBuilder tableRoute = new StringBuilder();
        if (Objects.equals(nameTable, "routePath")) {
                try (Connection con = DriverManager.getConnection(url, username, password)) {
                    Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nameTable);
                    while (resultSet.next()) {
                        int id = resultSet.getInt("ID");
                        String nameRoute = resultSet.getString("NameRoute");
                        int numberTrain = resultSet.getInt("NumberTrain");
                        tableRoute.append(nameRoute).append(" ");
                        tableRoute.append(numberTrain).append(" \n");
                    }
                }catch (Exception ex) {
                    System.out.println("Connection failed...");
                    System.out.println(ex);

                }
        }
        else {
                try (Connection con = DriverManager.getConnection(url, username, password)) {
                    Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nameTable);
                    while (resultSet.next()) {
                        int id = resultSet.getInt("ID");
                        String nameRoute = resultSet.getString("NameRoute");
                        int numberTrain = resultSet.getInt("NumberTrain");
                        tableRoute.append(nameRoute).append(" ");
                        tableRoute.append(numberTrain).append(" \n");
                        tableRoute.append(getTableRoutePath(numberTrain)).append("\n");
                    }
                }catch (Exception ex) {
                    System.out.println("Connection failed...");
                    System.out.println(ex);
            }
        }
        if (tableRoute.isEmpty()){
            return "An error occurred, the table was not displayed";
        }else {
            return tableRoute.toString();
        }
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

    public void deleteRoute(String nameRoute, int numberTrain){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM route");
            while (resultSet.next()){
                if (Objects.equals(resultSet.getString("NameRoute"), nameRoute)){
                    int id = resultSet.getInt("ID");
                    int rows = statement.executeUpdate("DELETE FROM route WHERE Id = " + id);
                    System.out.printf("%d row deleted ", rows);
                    deleteRoutePath(numberTrain);
                    return;

                }
            }
            System.out.println("The entered value was not found");

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
    }

    public void updateRoute(String columnName,String oldValue, String newValue){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            int i = 0;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM route");
            while (resultSet.next()){
                if (Objects.equals(resultSet.getString(columnName), oldValue)){
                    int id = resultSet.getInt("ID");
                    int rows = statement.executeUpdate("UPDATE route SET "+ columnName +" = '"+ newValue +"' WHERE Id = " + id);
                    System.out.printf("%d row updated ", rows);
                    return;
                }
            }
            System.out.println("The entered value was not found");

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
    }

    public void updateRoute(String columnName,int oldValue, int newValue){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            int i = 0;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM route");
            while (resultSet.next()){
                if (Objects.equals(resultSet.getInt(columnName), oldValue)){
                    int id = resultSet.getInt("ID");
                    int rows = statement.executeUpdate("UPDATE route SET "+ columnName +" = '"+ newValue +"' WHERE Id = " + id);
                    System.out.printf("%d row updated ", rows);
                    return;
                }
            }
            System.out.println("The entered value was not found");

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
    }

    public void writeNewRoutePath(String namePoint, String timeArrivals, String timeDepartures, int numberTrain){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            String sqlRequestNamePoint = "'"+ namePoint +"', ";
            String sqlRequestTimeArrivals = "'"+ timeArrivals +"', ";
            String sqlRequestTimeDepartures = "'"+ timeDepartures +"', ";
            int rows = statement.executeUpdate("INSERT routePath(NamePoint, TimeArrivals, TimeDepartures, NumberTrain) VALUES ("+ sqlRequestNamePoint + sqlRequestTimeArrivals + sqlRequestTimeDepartures+ numberTrain +")");
            System.out.println("Added 1 rows");

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public void deleteRoutePath(String namePoint, int numberTrain){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM routePath");
            while (resultSet.next()){
                if ((Objects.equals(resultSet.getString("NamePoint"), namePoint))&(Objects.equals(resultSet.getInt("NumberTrain"),numberTrain))){
                    int id = resultSet.getInt("ID");
                    int rows = statement.executeUpdate("DELETE FROM routePath WHERE Id = " + id);
                    System.out.printf("%d row deleted ", rows);
                    return;

                }
            }
            System.out.println("The entered value was not found");

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
    }

    public void deleteRoutePath(int numberTrain){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("DELETE FROM routePath WHERE NumberTrain = "+ numberTrain);
            System.out.printf("%d row(s) deleted", rows);
            //System.out.println("The entered value was not found");

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
    }

    public void updateRoutePath(String columnName, String oldValue, String newValue, int numberTrain){
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            int i = 0;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM routePath");
            while (resultSet.next()){
                if ((Objects.equals(resultSet.getString(columnName), oldValue))& (Objects.equals(resultSet.getInt("NumberTrain"), numberTrain))){
                    int id = resultSet.getInt("ID");
                    int rows = statement.executeUpdate("UPDATE routePath SET "+ columnName +" = '"+ newValue +"' WHERE Id = " + id);
                    System.out.printf("%d row updated ", rows);
                    return;
                }
            }
            System.out.println("The entered value was not found");

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
    }

}
