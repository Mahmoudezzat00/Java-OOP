package data.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MultiSet<E> {
    private HashMap<E, Integer> elemToCount;

    @SafeVarargs
    public MultiSet(E... elems) {
        elemToCount = new HashMap<>();
        for (E elem : elems) {
            add(elem);
        }
    }

    public int add(E elem) {
        int count = 1 + elemToCount.getOrDefault(elem, 0);
        elemToCount.put(elem, count);
        return count;
    }

    public int getCount(E elem) {
        return elemToCount.getOrDefault(elem, 0);
    }

    public MultiSet<E> intersect(MultiSet<E> other) {
        MultiSet<E> retval = new MultiSet<E>();
        for (E key : elemToCount.keySet()) { //foreach loop
            if (!other.elemToCount.containsKey(key)) continue;

            int count1 = elemToCount.get(key);
            int count2 = other.elemToCount.get(key);
            retval.elemToCount.put(key, Math.min(count1, count2));
        }
        return retval;
    }

    public int size() {
        int retval = 0;
        for (int count: elemToCount.values()) {
            retval += count;
        }
        return retval;
    }

    public int countExcept(Set<E> notCounted){ //[Sara, David]
        int retval = 0;
        for (Map.Entry<E, Integer> entry : elemToCount.entrySet()) {
            if (notCounted.contains(entry.getKey())) continue;
            retval += entry.getValue();
        }
        return retval;
    }
}