package ru;

import LinkedList.DoublyLinkedListForRoutePath;

import static ColorVar.colorvar.*;

public class Route {

    private int numberTrain; // Номер поезда(Пути)
    private String nameRoute; // Название пути

    //private final IList newLinkedList = new ILinkedList();

    public  Route(int numberTrain, String nameRoute){
        this.nameRoute = nameRoute;
        this.numberTrain = numberTrain;
        DBConnection B = new DBConnection();
        B.writeNewRoute(nameRoute,numberTrain);
    }

    private DoublyLinkedListForRoutePath newRouteList = new DoublyLinkedListForRoutePath(); //Список пути

    //////////////////////////////////////////////////////////////////////////////////////

    public String callNameRoute(){
        return nameRoute;
    } // Получить название пути

    public int callNumberRoute(){
        return numberTrain;
    }// Получить номер поезда(Пути)

    public void writeNameRoute(String currNameRoute){
        nameRoute = currNameRoute;
    } // Запись название пути

    public void writeNumberTrain(int currNumberRoute){
        numberTrain = currNumberRoute;
    } // Запись номера пути

    public void writeNewDeparturesPoint(RoutePath routePath) {
        newRouteList.addFirst(routePath);
    } // Запись первой остановки

    public void writeNewPoint(RoutePath routePath, int number) {
        newRouteList.insertByIndex(number-1, routePath);
        } // Запись остановки по индексу
    public void writeNewArrivalPoint(RoutePath routePath){
        newRouteList.addLast(routePath);
    } // Запись остановки (конечная) в конец списка

    //public void callRoutePoint() {
    //    return newRouteList.;
    //}
    public void callAllRoutePoint() {
        int i = 0;
        System.out.println("Название пути: " + ANSI_RED+ nameRoute +ANSI_RESET);
        System.out.println("Номер поезда: "+ ANSI_RED+Integer.toString(numberTrain) +ANSI_RESET);
        System.out.println(ANSI_BLUE+ "Остановки:" +ANSI_RESET);
        while (i< (newRouteList.toString().length()/22.5)){
            RoutePath h = newRouteList.getByIndex(i);
            System.out.println(ANSI_GREEN);
            System.out.println(h.getNamePoing());
            System.out.println(h.getTimeArrivals());
            System.out.println(h.getTimeDepartures());
            System.out.println(ANSI_RESET);
            i++;
        }
//        Object h;
//        while (i < newRouteList.toString().length()) ;
//        {
//            h = newRouteList.getByIndex(i);
//            //System.out.println(h);
//            i++;
//
//        }
        //return newRouteList.getByIndex(i);
    } // Вывести в консоль все остановки (название, время прибытия,отбытия)
    public int testLengthRouteList(){
        return newRouteList.toString().length();
    } //Метод проверки длины списка
}
