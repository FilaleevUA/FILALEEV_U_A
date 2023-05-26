//Задание 5
package ru.vsuet.Task5;
import java.util.Scanner;

public class Task5 {
    public static int[] getArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers (without spaces and commas): ");
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int[] IA = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            IA[i] = Integer.parseInt(s1[i]);
        }
        return IA;
    }
    public static int calculateResult(int[] IA) {
        int sum = 0;
        for (int i = 0; i < IA.length; i++) {
            sum += (IA[i] * IA[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculateResult(getArray()));
    }
}
