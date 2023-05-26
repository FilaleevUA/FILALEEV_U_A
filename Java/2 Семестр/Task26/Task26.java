package ru.vsuet.Task26;

import java.util.Scanner;

public class Task26 {
    public static String palindrome(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int i1 = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            maxLen = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                dp[i][i+1] = true;
                maxLen = 2;
                i1 = i;
            }
        }

        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len - k + 1; i++) {
                int j = i + k - 1;
                if (str.charAt(i) == str.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if (k > maxLen) {
                        maxLen = k;
                        i1 = i;
                    }
                }
            }
        }

        return str.substring(i1, i1 + maxLen) + " (" + maxLen + ")";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        String longestPalindrome = palindrome(str);
        System.out.println("Longest palindrome: " + longestPalindrome);
    }
}
