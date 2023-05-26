
package ru.vsuet.Task17;

import java.util.Scanner;

public class Task17 {
    public static String getLine() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string: ");
        return in.nextLine();
    }
    public static boolean RefactorMethod(String line) {

        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < line.length();  i++) {
            if (line.charAt(i) == '(') {
                i1 += 1;
            } else if (line.charAt(i) == ')') {
                i2 += 1;
            }
        }
        return i2 == i1;
    }

    public static void main(String[] args) {
        System.out.println(RefactorMethod(getLine()));;
}
}
