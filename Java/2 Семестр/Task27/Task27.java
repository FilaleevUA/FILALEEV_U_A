package ru.vsuet.Task27;

import java.util.Scanner;

public class Task27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = scanner.nextLine();
        System.out.print("Enter the shift number: ");
        int shift = scanner.nextInt();
        System.out.print("Enter the direction (left or right): ");
        String directionStr = scanner.next();
        int direction;
        if (directionStr.equalsIgnoreCase("left")) {
            direction = 1;
        } else if (directionStr.equalsIgnoreCase("right")) {
            direction = -1;
        } else {
            System.out.println("Incorrect direction");
            return;
        }

        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) ((int) c + shift * direction);
                if (c > 'я') {
                    c -= 32;
                } else if (c < 'а') {
                    c += 32;
                }
            }
            output += c;
        }

        System.out.println("Result: " + output);
    }
}
