package ru.vsuet.Task24;

import java.util.Scanner;

public class Task24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter M: ");
        int m = scanner.nextInt();

        System.out.print("Enter N: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of divisors: ");
        int numDivisors = scanner.nextInt();

        System.out.print("Enter the divisors: ");
        int[] divisors = new int[numDivisors];
        for (int i = 0; i < numDivisors; i++) {
            divisors[i] = scanner.nextInt();
        }

        for (int divisor : divisors) {
            int sum = 0;
            for (int i = m; i <= n; i++) {
                if (i % divisor == 0) {
                    sum += i;
                }
            }
            System.out.println("Sum for divisor " + divisor + ": " + sum);
        }
    }
}
