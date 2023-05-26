
package ru.vsuet.Task18;

import java.util.Arrays;
import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array of numbers (separated by spaces): ");
        String input = scanner.nextLine();
        String[] strArr = input.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i<strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }

        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        int[] leftArr = Arrays.copyOfRange(arr, 0, maxIndex);
        int[] rightArr = Arrays.copyOfRange(arr, maxIndex + 1, arr.length);
        System.out.println("Left array: " + Arrays.toString(leftArr));
        System.out.println("Right array: " + Arrays.toString(rightArr));
    }
}
