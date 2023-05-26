package ru.vsuet.Task23;

import java.util.Scanner;

public class Task23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = scanner.nextInt();

        System.out.print("Enter first divisor: ");
        int divisor1 = scanner.nextInt();

        System.out.print("Enter second divisor: ");
        int divisor2 = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % divisor1 == 0 || i % divisor2 == 0) {
                sum += i;
            }
        }
        StringBuilder row = new StringBuilder();
        for (int i = 1; i < n; i++){
            row.append(Integer.toString(i)).append(" ");
        }
        System.out.println("Row: " + row);
        System.out.println("Sum of numbers divisible by " + divisor1 + " or " + divisor2 + " in the range 1 to " + n + " is " + sum);
    }
}
