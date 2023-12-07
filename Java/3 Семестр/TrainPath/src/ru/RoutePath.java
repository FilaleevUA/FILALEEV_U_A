package ru;

import java.sql.Time;

public class RoutePath {

    private Time timeArrivals; // Переменная времени прибытия на остановку
    private Time timeDepartures; // Переменная времени отбытия от остановки

    private String namePoing; // Название остановки

    public RoutePath(String namePoing){
        this.namePoing  = namePoing;

    }


    public void setNamePoing(String currNamePoint){
        namePoing = currNamePoint;
    } // Задать название остановки
    public void setTimeArrivals(int hour, int minute, int sec){
        timeArrivals = new Time(hour,minute,sec);
    } // Задать время прибытия
    public void  setTimeDepartures(int hour, int minute, int sec){
        timeDepartures = new Time(hour,minute,sec);
    } // Задать время отбытия
    public String getTimeArrivals(){
        return timeArrivals.toString();
    } // Получить время прибытия
    public String getTimeDepartures(){
        return timeDepartures.toString();
    } // Получить время отбытия
    public String getNamePoing(){
        return namePoing;
    } //Получить название остановки
}
