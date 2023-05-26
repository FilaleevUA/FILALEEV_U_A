package ru.vsuet.Task20;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task20 {
    public static void main(String[] args) {
        int m = 5;
        int n = 4;
        int[][] arr = new int[m][n];

        int num = 1;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                arr[startRow][i] = num;
                num++;
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                arr[i][endCol] = num;
                num++;
            }
            endCol--;

            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    arr[endRow][i] = num;
                    num++;
                }
                endRow--;
            }

            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    arr[i][startCol] = num;
                    num++;
                }
                startCol++;
            }
        }

        try {
            FileWriter writer = new FileWriter("array.txt");
            for (int[] row : arr) {
                System.out.println(Arrays.toString(row));
                writer.write(Arrays.toString(row) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
