package ru.vsuet.Task22;

public class Task22 {
    public static double calculate(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    public static void main(String[] args) {
        System.out.println(calculate(4, 5, 3));
    }
}
