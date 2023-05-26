package ru.vsuet.Task15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string of repeated words: ");
        String str = input.nextLine();

        String[] words = str.split("\\s+");
        List<String> nonRepeatingWords = new ArrayList<>();
        for (String word : words) {
            if (!nonRepeatingWords.contains(word)) {
                nonRepeatingWords.add(word);
            }
        }
        String result = String.join(" ", nonRepeatingWords);

        System.out.println("Result: " + result.trim());
    }
}
