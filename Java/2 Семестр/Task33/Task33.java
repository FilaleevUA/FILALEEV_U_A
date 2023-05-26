package ru.vsuet.Task33;

import java.util.Scanner;

public class Task33 {
    public static long sticksLeft(long n, String player) {
        if (n == 1) {
            if (player.equals("Tanya")) {
                return 1;
            } else {
                return 0;
            }
        } else if (n % 2 == 0) {
            if (player.equals("Tanya")) {
                long half = n / 2;
                if (half % 2 == 0) {
                    return sticksLeft(half, "Sasha") + half;
                } else {
                    return sticksLeft(half + 1, "Sasha") + half;
                }
            } else {
                return sticksLeft(n - 1, "Tanya");
            }
        } else {
            return sticksLeft(n - 1, "Tanya");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sticks: ");
        long n = scanner.nextLong();

        long sashaSticks = n - sticksLeft(n, "Tanya");
        long tanyaSticks = sticksLeft(n, "Tanya");

        System.out.println("Tanya will have " + tanyaSticks + " sticks left.");
    }
}
