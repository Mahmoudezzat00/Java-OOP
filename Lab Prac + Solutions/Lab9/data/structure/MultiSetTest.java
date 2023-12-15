package data.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MultiSetTest {
    @Test
    public void multiSetInteger() {
        MultiSet<Integer> multiset = new MultiSet<>();
        assertEquals(0, multiset.size());
        assertEquals(0, multiset.getCount(0));

        multiset.add(123);
        assertEquals(0, multiset.getCount(0));
        assertEquals(1, multiset.getCount(123));

        multiset.add(123);
        assertEquals(0, multiset.getCount(0));
        assertEquals(2, multiset.getCount(123));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        abc, '', 5
        xyz, not in there, 5
    """)
    public void multiSetString(String txt, String missing, int count) {
        MultiSet<String> multiSet = new MultiSet<>();
        assertEquals(0, multiSet.size());
        assertEquals(0, multiSet.getCount(missing));

        multiSet.add(txt);
        assertEquals(1, multiSet.getCount(txt));
        assertEquals(0, multiSet.getCount(missing));

        for (int i = 0; i < count; i++) {
            multiSet.add(txt);
        }
        assertEquals(1+count, multiSet.getCount(txt));
        assertEquals(0, multiSet.getCount(missing));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        abba,     abrakadabra, a, 2, b, 2, 0
        abba,             bab, a, 1, b, 2, 0
        abba,            baba, a, 2, b, 2, 0
        tarkabab, abrakadabra, a, 3, b, 2, 2
    """)
    public void intersect(String part1, String part2, String counted1, int expected1, String counted2, int expected2, int otherCount) {
        MultiSet<String> orig1 = new MultiSet<>(part1.split(""));
        MultiSet<String> orig2 = new MultiSet<>(part2.split(""));

        MultiSet<String> result = orig1.intersect(orig2);
        assertEquals(expected1, result.getCount(counted1));
        assertEquals(expected2, result.getCount(counted2));
        assertEquals(otherCount, result.countExcept(Set.of(counted1, counted2)));
    }
}