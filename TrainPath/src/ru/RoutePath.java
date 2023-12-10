package ru;

import java.sql.Time;

public class RoutePath {

    private Time timeArrivals; // Переменная времени прибытия на остановку
    private Time timeDepartures; // Переменная времени отбытия от остановки

    private String namePoing; // Название остановки

    private int numberTrain; // Связующая между остановкой и путем

    public RoutePath() {
    }

    public RoutePath(String NamePoint, int NumberTrain, Time TimeArrivals, Time TimeDepartures) {
        this.namePoing = NamePoint;
        this.numberTrain = NumberTrain;
        this.timeArrivals = TimeArrivals;
        this.timeDepartures = TimeDepartures;
        DBConnection B = new DBConnection();
        B.writeNewRoutePath(namePoing, timeArrivals, timeDepartures, numberTrain);
    }


    public void updateRoutePath(String columnName, String oldValue, String newValue, int numberTrain) {
        DBConnection B = new DBConnection();
        B.updateRoutePath(columnName, oldValue, newValue, numberTrain);
    }

    public void deleteRoutePath(String NamePoint, int numberTrain) {
        DBConnection B = new DBConnection();
        B.deleteRoutePath(NamePoint, numberTrain);
    }
}
