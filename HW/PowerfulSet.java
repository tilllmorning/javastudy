package HW;
import java.util.LinkedHashSet;
import java.util.Set;

public class PowerfulSet {
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> res = new LinkedHashSet<>(set1);
        res.retainAll(set2);
        return res;
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> res = new LinkedHashSet<>(set1);
        res.addAll(set2);
        return res;
    }

    public static <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> res = new LinkedHashSet<>(set1);
        res.removeAll(set2);
        return res;
    }
}
