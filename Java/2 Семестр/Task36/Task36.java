package ru.vsuet.Task36;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Task36 {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] code = new int[4];
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int x;
            do {
                x = rand.nextInt(10);
            } while (used.contains(x));
            code[i] = x;
            used.add(x);
        }
        //System.out.printf("Сode: %d%d%d%d\n", code[0], code[1], code[2], code[3]);

        Scanner scanner = new Scanner(System.in);
        for (int attempt = 1; attempt <= 20; attempt++) {
            System.out.printf("Attempt #%d: Enter a 4-number: ", attempt);
            int[] guess = new int[4];
            String input = scanner.nextLine();
            boolean valid = true;
            if (input.length() != 4) {
                valid = false;
            } else {
                for (int i = 0; i < 4; i++) {
                    try {
                        guess[i] = Integer.parseInt(input.substring(i, i + 1));
                    } catch (NumberFormatException e) {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) {
                System.out.println("Enter 4 digits.");
                continue;
            }
            int matchCount = 0;
            for (int i = 0; i < 4; i++) {
                if (guess[i] == code[i]) {
                    matchCount++;
                }
            }
            if (matchCount == 4) {
                System.out.println("You guessed right");
                break;
            } else if (attempt == 20) {
                System.out.println("Attempts ended");
                System.out.printf("Сode: %d%d%d%d\n", code[0], code[1], code[2], code[3]);
                break;
            } else {
                int partialMatchCount = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (i != j && guess[i] == code[j]) {
                            partialMatchCount++;
                            break;
                        }
                    }
                }
                System.out.printf("Match: %d. Matches: %d.\n", matchCount, partialMatchCount);
            }
        }
    }
}
