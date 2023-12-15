package loop;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import loop.iterator.GoAroundIterator;

public class GoAroundTest {
    @Test
    public void test() {
        GoAround<Integer> ga = new GoAround<>(2, 1, 2, 3, 4);
        GoAroundIterator<Integer> it = ga.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertTrue(it.hasNext());
        assertEquals(4, it.next());

        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertTrue(it.hasNext());
        assertEquals(4, it.next());

        assertFalse(it.hasNext());
    }
}
