package ru;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        /*// Создание новых путей
        Route b = new Route(1, "Первая круговая");

        // Создание новых остановок
        RoutePath h = new RoutePath("Первая");
        RoutePath m = new RoutePath("Пушкинская - 2-я");
        RoutePath j = new RoutePath("Калашникова - 3-я");
        RoutePath u = new RoutePath("Конечная");

        // Добавление времени на остановке
        m.setTimeArrivals(2,0,0);
        m.setTimeDepartures(2,15,0);

        // Добавление времени на остановке
        h.setTimeArrivals(0,30,15);
        h.setTimeDepartures(0,32,15);

        // Добавление времени на остановке
        j.setTimeArrivals(3,0,0);
        j.setTimeDepartures(3,15,0);

        // Добавление времени на остановке
        u.setTimeArrivals(3,30,0);
        u.setTimeDepartures(4, 0,0);

        //Добавляем в путь новые остановки
        b.writeNewDeparturesPoint(h);
        b.writeNewArrivalPoint(u);
        b.writeNewPoint(m,2);
        b.writeNewPoint(j,3);


        RoutePath newPath = new RoutePath("Особенная - 4-я");
        newPath.setTimeArrivals(3,0,0);
        newPath.setTimeDepartures(3,15,0);

        b.writeNewPoint(newPath,4);



        //Вывод всех точек остановки
        b.callAllRoutePoint();
        */
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainPath", "root", "root");
        //con.close();
        try{
            String url = "\"jdbc:mysql://localhost:3306/TrainPath\"";
            String username = "root";
            String password = "root";
            //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            // команда создания таблицы
            String sqlCommand = "CREATE TABLE route (Id INT PRIMARY KEY AUTO_INCREMENT, NameRoute VARCHAR(20), NumberTrain INT)";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainPath", "root", "root");){

                Statement statement = conn.createStatement();
                // создание таблицы
                statement.executeUpdate(sqlCommand);

                System.out.println("Database has been created!");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }


    }
}