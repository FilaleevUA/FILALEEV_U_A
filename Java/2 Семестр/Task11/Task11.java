
package ru.vsuet.Task11;

import java.util.Scanner;
public class Task11 {
    public static String removeVowels() {

        String[] allRussianVowelsLowercase = {"а", "о", "у", "ы", "э", "е", "ё", "и", "ю", "я"};
        String[] allRussianVowelsUppercase = {"А", "О", "У", "Ы", "Э", "Е", "Ё", "И", "Ю", "Я"};

        String[] allEnglishVowelsLowercase = {"a", "e", "i", "o", "u", "y"};
        String[] allEnglishVowelsUppercase = {"A", "E", "I", "O", "U", "Y"};

        Scanner in = new Scanner(System.in);
        System.out.println("Enter string from which yo want to remove the vowels: ");
        String line = in.nextLine();
        for (int i = 0; i < allRussianVowelsUppercase.length; i++) {
            line = line.replace(allRussianVowelsUppercase[i], "");
            line = line.replace(allRussianVowelsLowercase[i], "");
        }
        for (int j = 0; j < allEnglishVowelsUppercase.length; j++) {
            line = line.replace(allEnglishVowelsUppercase[j], "");
            line = line.replace(allEnglishVowelsLowercase[j], "");
        }
        return line;
    }
    public static void main(String[] args) {
        System.out.println(removeVowels());
    }
}
