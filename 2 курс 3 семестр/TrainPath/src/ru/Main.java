package ru;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Time setTime(int hour, int minute, int second){
        return new Time(hour, minute, second);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите действие: 1-Добавить новый путь; 2-Обновить путь; 3-удалить путь; 4-вывести в консоль все пути и их остановки, 5 - Создать новые таблицы route и RoutePath.\n Введите число: ");
        int num = scanner.nextInt();
        switch (num){
            case 1:
                System.out.println("Введите количество путей, которое нужно создать:");
                int count = scanner.nextInt();
                int i = 0;
                scanner.nextLine();
                while (count>i){
                    int numberTrain = 0;
                    String nameRoute = "";
                    System.out.println("Введите название пути: ");
                    nameRoute = scanner.nextLine();
                    if (Objects.equals(nameRoute, "")){
                        System.out.println("Вы не ввели название пути!");
                        return;
                    }else {
                        System.out.println("Введите номер поезда: ");
                        numberTrain = scanner.nextInt();
                    }
                    Route newRoute = new Route(numberTrain,nameRoute);
                    i++;
                    System.out.println("\n Введите количество создаваемых остановок для этого пути: ");
                    int countRoutePath = scanner.nextInt();
                    scanner.nextLine();
                    int j = 0;
                    while (countRoutePath>j){
                        System.out.println("Введите название остановки: ");
                        String nameRoutePath = scanner.nextLine();
                        System.out.println("Введите время прибытия (По формату: (00:00:00)): ");
                        String timeArrivalsRoutePath = scanner.nextLine();
                        System.out.println("Введите время отбытия (По формату: (00:00:00)): ");
                        String timeDeparturesRoutePath = scanner.nextLine();
                        newRoute.writeNewRoutePath(nameRoutePath, timeArrivalsRoutePath, timeDeparturesRoutePath);
                        j++;
                    }
                }
                return;
            case 2:
                scanner.nextLine();
                System.out.println("Введите название пути, которое нужно обновить: ");
                String nameRoute = scanner.nextLine();
                System.out.println("Введите действие (1 - Обновить название пути; 2 - Обновить номер поезда): ");
                int number = scanner.nextInt();
                scanner.nextLine();
                switch (number){
                    case 1:
                        System.out.println("Введите новое название: ");
                        String newNameRoute = scanner.nextLine();
                        //DBConnection dbConnection = new DBConnection();
                        //dbConnection.updateRoute("NameRoute",nameRoute,newNameRoute);
                        Route route = new Route();
                        route.updateRoute("NameRoute", nameRoute, newNameRoute);
                        return;
                    case 2:
                        System.out.println("Введите старый номер поезда: ");
                        int numberTrain = scanner.nextInt();
                        System.out.println("Введите новый номер поезда: ");
                        int newNumberTrain = scanner.nextInt();
                        Route route1 = new Route();
                        route1.updateRoute("NumberTrain", numberTrain, newNumberTrain);
                        return;
                    default:
                        System.out.println("Вы не ввели значение!");
                        break;
                }
                return;
            case 3:
                scanner.nextLine();
                System.out.println("Введите название пути, которое нужно удалить: ");
                String nameRoute1 = scanner.nextLine();
                System.out.println("Введите номер поезда пути: ");
                int numberTrain = scanner.nextInt();
                Route route = new Route();
                route.deleteRoute(nameRoute1,numberTrain);
                return;
            case 4:
                DBConnection dbConnection = new DBConnection();
                System.out.println(dbConnection.getTable("route"));
                return;
            case 5:
                DBConnection dbConnection1 = new DBConnection();
                dbConnection1.createTableRoute();
                dbConnection1.createTableRoutePath();
        }

    }
}