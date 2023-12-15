package data.structure.peculiar;

import java.util.ArrayList;
import java.util.HashSet;

@SuppressWarnings("serial")
public class StuffyList<E> extends ArrayList<HashSet<E>> {
    private E neededElement;

    public StuffyList(E neededElement) {
        this.neededElement = neededElement;
    }

    @Override
    public boolean add(HashSet<E> set) {
        HashSet<E> targetSet = set.contains(neededElement) ? set : new HashSet<>(set);
        targetSet.add(neededElement);
        return super.add(targetSet);
    }
}
