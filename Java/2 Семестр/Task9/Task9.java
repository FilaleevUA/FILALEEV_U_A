
package ru.vsuet.Task9;

import java.util.Scanner;
public class Task9 {
    public static boolean isEnd() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first String: ");
        String[] first = in.nextLine().split("");
        System.out.println("Enter second String: ");
        String[] second = in.nextLine().split("");
        boolean isError = false;
        int j = first.length - 1;
        for (int i = second.length - 1; i > 0; i--) {
            if (!first[j].equals(second[i])) {
                return false;
            }
            j -= 1;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isEnd());
    }
}
