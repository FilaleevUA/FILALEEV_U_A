package ru.vsuet.Task28;

import java.util.Scanner;

public class Task28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int j = n / i;

                if ((i + j) % 2 == 0 && (j - i) % 2 == 0) {
                    int x = (i + j) / 2;
                    int y = (j - i) / 2;

                    if ((x >= 1) && (x < 100000) && (y >= 1) && (y < 100000)) {
                        System.out.println("Square difference: " + x*x + "-" + y*y);
                        System.out.println("The necessary numbers: " + x + " " + y);
                    }
                }
            }
        }
    }
}
