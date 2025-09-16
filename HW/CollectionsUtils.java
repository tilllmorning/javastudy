package HW;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionsUtils {
    public static <T> Set<T> unique(ArrayList<T> list) {
        return new LinkedHashSet<>(list);
    }
}
