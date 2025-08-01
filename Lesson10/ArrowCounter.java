package Lesson10;

import java.util.Scanner;

public class ArrowCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку (из символов < > -): ");
        String input = scanner.nextLine();

        String arrow1 = ">>-->";
        String arrow2 = "<--<<";

        int count = 0;

        for (int i = 0; i <= input.length() - 5; i++) {
            String part = input.substring(i, i + 5);
            if (part.equals(arrow1) || part.equals(arrow2)) {
                count++;
            }
        }

        System.out.println("Количество стрел: " + count);
    }
}
