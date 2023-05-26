package ru.vsuet.Task31;

import java.util.Arrays;
import java.util.Scanner;

public class Task31 {
    public static int[][] fibonachi(int i) {

        int[] fib = new int[i+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int j = 2; j <= i; j++) {
            fib[j] = fib[j-1] + fib[j-2];
        }


        int[] digitCounts = new int[10];
        for (char digit : Integer.toString(fib[i]).toCharArray()) {
            digitCounts[Character.getNumericValue(digit)]++;
        }


        int maxDit = -1;
        int maxCount = 0;
        for (int digit = 0; digit < 10; digit++) {
            if (digitCounts[digit] > maxCount) {
                maxDit = digit;
                maxCount = digitCounts[digit];
            } else if (digitCounts[digit] == maxCount && maxDit != -1) {
                maxDit = Math.max(maxDit, digit);
            }
        }

        return new int[][]{{maxCount, maxDit}};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int i = scanner.nextInt();
        scanner.close();

        int[][] result = fibonachi(i);

        System.out.println("f(" + i + ") = " + Arrays.toString(result[0]));
    }
}
