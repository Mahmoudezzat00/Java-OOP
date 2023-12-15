package data.organiser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OrganiserTest {
    @Test
    public void testInteger() {
        Organiser<Integer> organiser = new Organiser<>(1, 3, 5, 7, 9);
        assertEquals("[1 3 5 7 9 ]", organiser.toString());

        organiser.addSwap(0, 1);
        organiser.runSwaps();
        assertEquals("[3 1 5 7 9 ]", organiser.toString());
        organiser.runSwaps();
        assertEquals("[1 3 5 7 9 ]", organiser.toString());

        organiser.addSwap(0, 3);
        organiser.runSwaps();
        assertEquals("[7 1 5 3 9 ]", organiser.toString());

        int elem = organiser.get(0);
        assertEquals(14, elem*2);
    }

    @Test
    public void testString() {
        Organiser<String> organiser = new Organiser<>("a b c d e".split(" "));
        assertEquals("[a b c d e ]", organiser.toString());

        organiser.addSwap(0, 1);
        organiser.runSwaps();
        assertEquals("[b a c d e ]", organiser.toString());
        organiser.runSwaps();
        assertEquals("[a b c d e ]", organiser.toString());

        organiser.addSwap(0, 3);
        organiser.runSwaps();
        assertEquals("[d a c b e ]", organiser.toString());

        String elem = organiser.get(0);
        assertEquals(1, elem.length());
    }

    @Test
    public void testDouble() {
        Organiser<Double> organiser = new Organiser<>(2.3, 5.6, -3.4, 12.2);
        assertEquals("[2.3 5.6 -3.4 12.2 ]", organiser.toString());

        organiser.addSwap(0, 1);
        organiser.runSwaps();
        assertEquals("[5.6 2.3 -3.4 12.2 ]", organiser.toString());
        organiser.runSwaps();
        assertEquals("[2.3 5.6 -3.4 12.2 ]", organiser.toString());

        organiser.addSwap(0, 3);
        organiser.runSwaps();
        assertEquals("[12.2 2.3 -3.4 5.6 ]", organiser.toString());

        double elem = organiser.get(0);
        assertTrue(12.1 < elem);
        assertTrue(elem < 12.3);
    }
}
