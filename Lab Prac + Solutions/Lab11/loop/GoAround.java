package loop;

import java.util.ArrayList;
import java.util.List;

import loop.iterator.GoAroundIterator;

public class GoAround<T> implements Iterable<T> {
    private int roundCount;
    private List<T> elements;

    public GoAround(int roundCount, @SuppressWarnings("unchecked") T... elements) {
        this.roundCount = roundCount;
        this.elements = new ArrayList<>(elements.length);
        for (T element : elements) {
            this.elements.add(element);
        }
    }

    @Override
    public GoAroundIterator<T> iterator() {
        return new GoAroundIterator<>(roundCount, elements);
    }
}
