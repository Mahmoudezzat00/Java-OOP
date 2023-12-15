package data.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListUtilTest {
    @Test
    public void divs0() {
        assertEquals(List.of(), ListUtil.divisors(0));
    }

    @Test
    public void divs1() {
        assertEquals(List.of(1), ListUtil.divisors(1));
    }

    @Test
    public void divs64() {
        assertEquals(List.of(1, 2, 4, 8, 16, 32, 64), ListUtil.divisors(64));
    }

    @Test
    public void withSameStartEnd() {
        ArrayList<String> txts = new ArrayList<>();
        assertEquals(List.of(), ListUtil.withSameStartEnd(txts));

        txts.add("");
        assertEquals(List.of(), ListUtil.withSameStartEnd(txts));

        txts.add(null);
        assertEquals(List.of(), ListUtil.withSameStartEnd(txts));

        txts.add(" ");
        assertEquals(List.of(" "), ListUtil.withSameStartEnd(txts));

        txts.add("x");
        assertEquals(List.of(" ", "x"), ListUtil.withSameStartEnd(txts));

        txts.add("");
        assertEquals(List.of(" ", "x"), ListUtil.withSameStartEnd(txts));

        txts.add("different start and end?");
        assertEquals(List.of(" ", "x"), ListUtil.withSameStartEnd(txts));

        txts.add("ends and starts the same");
        assertEquals(List.of(" ", "x", "ends and starts the same"), ListUtil.withSameStartEnd(txts));
    }

    @Test
    public void minToFront() {
        ListUtil.maxToFront(null);

        ArrayList<String> txts = new ArrayList<>();
        ListUtil.maxToFront(txts);
        assertEquals(List.of(), txts);

        ArrayList<String> txts2 = new ArrayList<>();
        txts2.add("can");
        txts2.add("you");
        txts2.add("succeed");
        ListUtil.maxToFront(txts2);
        assertEquals(List.of("you", "can", "succeed"), txts2);

        ArrayList<String> txts3 = new ArrayList<>();
        txts3.add("-123");
        txts3.add("2000");
        txts3.add("100");
        ListUtil.maxToFront(txts3);
        assertEquals(List.of("2000", "-123", "100"), txts3);
    }
}
