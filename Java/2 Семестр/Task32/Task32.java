package ru.vsuet.Task32;

import java.util.Scanner;

public class Task32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sticks: ");
        long n = scanner.nextLong();
        String winner = findWinner(n, "Sasha");
        System.out.println("The winner is " + winner + ".");
    }

    public static String findWinner(long n, String player) {
        if (n == 1) {
            return player;
        } else if (n % 2 == 0) {
            return findWinner(n / 2, player.equals("Sasha") ? "Tanya" : "Sasha");
        } else {
            return player;
        }
    }
}
