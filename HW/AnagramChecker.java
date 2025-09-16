package HW;
import java.util.Arrays;

public class AnagramChecker {
   public static boolean isAnagram(String s, String t) {
        char[] a = s.toLowerCase().replaceAll("[^\\p{L}\\p{Nd}]+", "").toCharArray();
        char[] b = t.toLowerCase().replaceAll("[^\\p{L}\\p{Nd}]+", "").toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    } 
}
