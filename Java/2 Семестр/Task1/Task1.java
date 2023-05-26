
package ru.vsuet.Task1;
import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static int[][] createMatrix(int column, int line) {
        int[][] matrix = new int[column][line];
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = generateRandomNumber(1, 9);
            }
        }
        return matrix;
    }
    public static int generateRandomNumber(int min, int max) {
        Random number = new Random();
        return number.nextInt(max - min + 1) + min;
    }
    public static void transpose(int[][] matrix, int column, int lines) {
        int[][] newMatrix = createMatrix(column, lines);

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                newMatrix[i][j] = matrix[j][i];
            }
        }

        System.out.println("Transpose matrix: ");
        printMatrix(newMatrix);
    }
    public static void printMatrix(int[][] matrix) {
        int[][] matrix1 = matrix;
        int idx = matrix.length;

        for(int i = 0; i < idx; ++i) {
            int[] id = matrix1[i];
            System.out.println(Arrays.toString(id));
        }

    }
    public static void main(String[] args) {
        int columnsAndLinesAmount = 4;
        int[][] matrix = createMatrix(columnsAndLinesAmount, columnsAndLinesAmount);
        System.out.println();
        transpose(matrix, columnsAndLinesAmount, columnsAndLinesAmount);
    }
}
