package ru;

import java.sql.*;

public class Main {
    public static Time setTime(int hour, int minute, int second){
        return new Time(hour, minute, second);
    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        dbConnection.createTableRoute();
        dbConnection.createTableRoutePath();


        Route firstRoute9KS = new Route(9,"Путь 9кс");

        firstRoute9KS.writeNewRoutePath("Московский проспект",setTime(9,10,0),setTime(9,15,0));
        firstRoute9KS.writeNewRoutePath("Московский проспект-2", setTime(9,20,0),setTime(9,40,0));


        Route secondRoute3 = new Route(3,"Путь 3");

        secondRoute3.writeNewRoutePath("Институт ВГУИТ", setTime(9,10,0),setTime(9,15,0));
        secondRoute3.writeNewRoutePath("Конечная",setTime(9,30,0),setTime(9,45,0));

        secondRoute3.updateRoutePath("NamePoint","Конечная","Вовсе не конечная");
        secondRoute3.deleteRoutePath("Институт ВГУИТ");





        firstRoute9KS.deleteRoute();



    }
}