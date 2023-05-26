
package ru.vsuet.Task7;

import java.util.Scanner;
public class Task7 {
    public static int getNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = in.nextInt();
        return number;
    }
    public static int calculateResult(int number) {
        int mrSq = (int) Math.ceil(Math.sqrt(number));
        int lsSq = (int) Math.floor(Math.sqrt(number));
        int res = (number - (Math.pow(mrSq, 2))) > (number - (Math.pow(lsSq, 2))) ? mrSq : lsSq;
        return res;
    }
    public static void main(String[] args) {
        System.out.println(calculateResult(getNumber()));
    }
}
