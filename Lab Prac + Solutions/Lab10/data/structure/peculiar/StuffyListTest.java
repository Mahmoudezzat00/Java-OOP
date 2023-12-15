package data.structure.peculiar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class StuffyListTest {
    @Test
    public void test() {
        StuffyList<Integer> stuffyList = new StuffyList<>(123);
        stuffyList.add(new HashSet<>());

        assertEquals(List.of(Set.of(123)), stuffyList);
    }

    @Test
    public void test2() {
        StuffyList<Integer> stuffyList = new StuffyList<>(123);
        HashSet<Integer> set = new HashSet<>();
        set.add(123);
        stuffyList.add(set);

        assertEquals(List.of(Set.of(123)), stuffyList);
    }

    @Test
    public void test456() {
        StuffyList<Integer> stuffyList = new StuffyList<>(123);
        HashSet<Integer> set = new HashSet<>();
        set.add(456);
        set.add(789);
        stuffyList.add(set);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(10000);
        set2.add(-10000);
        stuffyList.add(set2);

        assertEquals(List.of(Set.of(123, 456, 789), Set.of(123, 10000, -10000)), stuffyList);
    }
}
