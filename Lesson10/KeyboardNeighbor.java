package Lesson10;

import java.util.Scanner;

public class KeyboardNeighbor {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите одну букву (англ, строчную): ");
        String input = scanner.nextLine().toLowerCase();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Ошибка: введите одну строчную букву английского алфавита.");
            return;
        }

        char c = input.charAt(0);
        char result;

        switch (c) {
            case 'a': result = 'p'; break;
            case 'p': result = 'a'; break;
            case 'l': result = 'z'; break;
            case 'z': result = 'l'; break;
            case 'm': result = 'q'; break;
            case 'q': result = 'm'; break;
            default: result = (char)(c - 1);
        }

        System.out.println("Слева на клавиатуре: " + result);
    }    
}
