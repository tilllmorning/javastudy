package HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
public static void main(String[] args) {
        demoUnique();
        demoAnagram();
        demoPowerfulSet();
    }

    private static void demoUnique() {
        System.out.println("=== Задание 1: уникальные элементы ===");
        ArrayList<Integer> src = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4));
        System.out.println("Исходный список: " + src);
        System.out.println("Уникальные: " + CollectionsUtils.unique(src));
    }

    private static void demoAnagram() {
        System.out.println("\n=== Задание 2: анаграммы ===");
        String s = "Бейсбол";
        String t = "бобслей";
        System.out.println(s + " / " + t + " → " + AnagramChecker.isAnagram(s, t));
    }

    private static void demoPowerfulSet() {
        System.out.println("\n=== Задание 3: PowerfulSet ===");
        Set<Integer> set1 = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(0, 1, 2, 4));

        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);
        System.out.println("intersection = " + PowerfulSet.intersection(set1, set2));
        System.out.println("union = " + PowerfulSet.union(set1, set2));
        System.out.println("relativeComplement = " + PowerfulSet.relativeComplement(set1, set2));
    }
}
