package ru.vsuet.Task25;

import java.util.Scanner;

public class Task25 {
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
        int sum = 0;
        for (int i = m; i<=n; i++) {
            for (int divisor : divisors) {
                if (i % divisor == 0) {
                    sum += 1;
                }
            }
        }
        System.out.println("Sum number: " + sum);
    }
}
