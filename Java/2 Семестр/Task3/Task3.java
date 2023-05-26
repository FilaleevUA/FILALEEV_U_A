package ru.vsuet.Task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the coordinates of the three points separated by commas and in square brackets, for example: ([4, 6], [12, 4], [10, 10]): ");
        String points = input.nextLine();

        points = points.replaceAll("\\[", "").replaceAll("\\]", "");
        String[] coordinates = points.split(", ");

        double x1 = Double.parseDouble(coordinates[0]);
        double y1 = Double.parseDouble(coordinates[1]);
        double x2 = Double.parseDouble(coordinates[2]);
        double y2 = Double.parseDouble(coordinates[3]);
        double x3 = Double.parseDouble(coordinates[4]);
        double y3 = Double.parseDouble(coordinates[5]);

        double barycenterX = (x1 + x2 + x3) / 3;
        double barycenterY = (y1 + y2 + y3) / 3;

        System.out.printf("Triangle barycenter: {%.4f, %.4f}", barycenterX, barycenterY);
    }
}
