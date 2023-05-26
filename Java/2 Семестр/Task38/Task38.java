package ru.vsuet.Task38;

import java.util.Scanner;

public class Task38 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();
        String[] words = text.split("\\s+|(?=\\p{Punct})|(?<=\\p{Punct})");
        String result = "";

        for(String word : words) {
            if(word.matches("[а-яА-ЯёЁ]+")) {
                char firstLetter = word.charAt(0);
                StringBuilder sWord = new StringBuilder(word).reverse();
                result += sWord + "ауч ";
            } else {
                result += word + " ";
            }
        }

        System.out.println("Replace: " + result.trim());
    }
}

