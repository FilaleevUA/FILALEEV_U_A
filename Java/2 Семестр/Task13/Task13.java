
package ru.vsuet.Task13;

import java.util.Scanner;
public class Task13 {
    public static void getResult() {

        Scanner enteredNumbers = new Scanner(System.in);
        System.out.println("Enter the beginning of the row, step, number of steps: ");
        String[] stringArray = enteredNumbers.nextLine().split(" ");

        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        int begRow = intArray[0];
        int step = intArray[1];
        int numberSteps = intArray[2];

        int count = 0;

        while (count != numberSteps) {
            System.out.println(begRow);
            begRow += step;
            count += 1;
        }
    }
    public static void main(String[] args) {
        getResult();
    }
}
