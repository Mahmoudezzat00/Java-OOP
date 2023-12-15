
package data.organiser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Organiser<T> {
    private ArrayList<T> elems;
    private ArrayList<Map.Entry<Integer, Integer>> swaps;

    @SafeVarargs
    public Organiser(T... elems) {
        this.elems = new ArrayList<>(Arrays.asList(elems));
        swaps = new ArrayList<>();
    }

    public T get(int idx) {
        return elems.get(idx);
    }

    public ArrayList<T> get() {
        return new ArrayList<>(elems);
    }

    public void addSwap(int from, int to) {
        swaps.add(Map.entry(from, to));
    }

    private void swap(int from, int to) {
        T tmp = elems.get(from);
        elems.set(from, elems.get(to));
        elems.set(to, tmp);
    }

    public void runSwaps() {
        for (Map.Entry<Integer, Integer> swap : swaps) {
            swap(swap.getKey(), swap.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T elem : elems) {
            sb.append(elem.toString());
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}

