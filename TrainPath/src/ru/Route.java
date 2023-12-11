package ru;

import java.sql.*;

public class Route {

    private int numberTrain; // Номер поезда(Пути)
    private String nameRoute; // Название пути

    public  Route(int numberTrain, String nameRoute){
        this.nameRoute = nameRoute;
        this.numberTrain = numberTrain;
        DBConnection B = new DBConnection();
        B.writeNewRoute(nameRoute,numberTrain);
    }

    public Route(){}

    //////////////////////////////////////////////////////////////////////////////////////

    public void writeNewRoutePath(String namePoint, String timeArrivals, String timeDepartures) {
        RoutePath routePath = new RoutePath(namePoint, numberTrain, timeArrivals, timeDepartures);
    }

    public void updateRoutePath(String columnName, String oldValue, String newValue){
        RoutePath routePath = new RoutePath();
        routePath.updateRoutePath(columnName,oldValue,newValue,numberTrain);
    }

    public void deleteRoutePath(String nameRoutePath){
        RoutePath routePath = new RoutePath();
        routePath.deleteRoutePath(nameRoutePath, numberTrain);
    }

    public void deleteRoute(String nameRoute, int numberTrain){
        DBConnection B = new DBConnection();
        B.deleteRoute(nameRoute,numberTrain);
    }

    public void updateRoute(String columnName, String oldValue, String newValue){
        DBConnection B = new DBConnection();
        B.updateRoute(columnName,oldValue,newValue);
    }
    public void updateRoute(String columnName, int oldValue, int newValue){
        DBConnection B = new DBConnection();
        B.updateRoute(columnName,oldValue,newValue);
    }
}
