package ru.vsuet.Task19;
import java.util.Scanner;
public class Task19 {
    public static int func(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n % 2 == 0) { //n / 2 == (int) n / 2
            return func(n / 2);
        } else {
            return func((n - 1)/ 2) + func(((n - 1) / 2) + 1 );
        }
    }
    public static int scaner() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        return in.nextInt();
    }
    public static void main(String[] args) {
        System.out.println(func(scaner()));
    }
}