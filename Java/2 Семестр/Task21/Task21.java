package ru.vsuet.Task21;

import java.util.Scanner;

public class Task21 {
    public static String scaner() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter line: ");
        return in.nextLine();
    }
    public static String solveLine(String line) {
        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)) {
                case ('1') -> line = line.substring(0, i) + '7' + line.substring(i + 1);
                case ('2') -> line = line.substring(0, i) + '8' + line.substring(i + 1);
                case ('3') -> line = line.substring(0, i) + '9' + line.substring(i + 1);
                case ('7') -> line = line.substring(0, i) + '1' + line.substring(i + 1);
                case ('8') -> line = line.substring(0, i) + '2' + line.substring(i + 1);
                case ('9') -> line = line.substring(0, i) + '3' + line.substring(i + 1);
            }
        }
        return line;
    }
    public static void main(String[] args) {
        System.out.println(solveLine(scaner()));
    }
}
