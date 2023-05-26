package ru.vsuet.Task30;
import java.util.ArrayList;
import java.util.Arrays;

public class Task30 {
    public static ArrayList<Integer> chooseBestSum(int maxDist, int citiesVisit, int[] cityDistances) {
        ArrayList<Integer> bestCombination = null;

        int bestDistance = 0;

        int[] indices = new int[citiesVisit];
        for (int i = 0; i < citiesVisit; i++) {
            indices[i] = i;
        }
        while (indices[0] <= cityDistances.length - citiesVisit) {
            ArrayList<Integer> combination = new ArrayList<>();
            for (int index : indices) {
                combination.add(cityDistances[index]);
            }

            int combinationDistance = combination.stream().mapToInt(Integer::intValue).sum();
            if (combinationDistance <= maxDist) {
                if (combinationDistance > bestDistance) {
                    bestDistance = combinationDistance;
                    bestCombination = combination;
                }
            }

            int i = citiesVisit - 1;
            while (i >= 0 && indices[i] == cityDistances.length - citiesVisit + i) {
                i--;
            }
            if (i < 0) {
                break;
            }
            indices[i]++;
            for (int j = i + 1; j < citiesVisit; j++) {
                indices[j] = indices[j - 1] + 1;
            }
        }

        return bestCombination;
    }

    public static void main(String args[]) {
        int[] cityDistances = {50, 55, 57, 58, 60};
        int maxDist = 163;
        int citiesVisit = 3;
        ArrayList<Integer> bestCombination = chooseBestSum(maxDist, citiesVisit, cityDistances);
        if (bestCombination != null) {
            System.out.println("Max distance: " + maxDist);
            System.out.println("Best combination: " + Arrays.toString(bestCombination.toArray()));
        } else {
            System.out.println("No valid combinations found.");
        }
    }
}
