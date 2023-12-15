package worker.schedule;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WorkerScheduleTest {
    @Test
    public void emptySchedule() {
        WorkerSchedule schedule = new WorkerSchedule();
        assertFalse(schedule.isWorkingOnWeek("John", 0));
    }

    @ParameterizedTest
     @CsvSource("""
        Jack,    true, false, false
        Jill,    true, false, false
        Sam,    false,  true, false
        Max,    false,  true, false
        Stan,   false, false,  true
        Pan,    false, false,  true
        Tom,     true, false,  true
        Jerry,   true, false,  true
        Romeo,  false, true,   true
        Juliet, false, true,   true
    """)
    public void schedule(String person, boolean onWeek1, boolean onWeek2, boolean onWeek3) {
        WorkerSchedule schedule = new WorkerSchedule();

        HashSet<String> workers1 = new HashSet<>();
        workers1.add("Jack");
        workers1.add("Jill");

         HashSet<String> workers2 = new HashSet<>();
        workers2.add("Sam");
        workers2.add("Max");
   
       HashSet<String> workers3 = new HashSet<>();
        workers3.add("Stan");
        workers3.add("Pan");
    
        schedule.add(1, workers1);
        schedule.add(2, workers2);
        schedule.add(3, workers3);

        HashSet<Integer> weeks1_3 = new HashSet<>();
        weeks1_3.add(1);
        weeks1_3.add(3);
        schedule.add(weeks1_3, new ArrayList<>(List.of("Tom", "Jerry")));

        HashSet<Integer> weeks2_3 = new HashSet<>();
        weeks2_3.add(2);
        weeks2_3.add(3);
        schedule.add(weeks2_3, new ArrayList<>(List.of("Romeo", "Juliet")));

        assertFalse(schedule.isWorkingOnWeek(person, -1));
        assertFalse(schedule.isWorkingOnWeek(person, 0));
        assertFalse(schedule.isWorkingOnWeek(person, 5));

        assertEquals(onWeek1, schedule.isWorkingOnWeek(person, 1));
        assertEquals(onWeek2, schedule.isWorkingOnWeek(person, 2));
        assertEquals(onWeek3, schedule.isWorkingOnWeek(person, 3));

        assertEquals(Set.of(1), schedule.getWorkWeeks("Jack"));
        assertEquals(Set.of(1), schedule.getWorkWeeks("Jill"));
        assertEquals(Set.of(2), schedule.getWorkWeeks("Sam"));
        assertEquals(Set.of(2), schedule.getWorkWeeks("Max"));
        assertEquals(Set.of(3), schedule.getWorkWeeks("Stan"));
        assertEquals(Set.of(3), schedule.getWorkWeeks("Pan"));
        assertEquals(Set.of(1,3), schedule.getWorkWeeks("Tom"));
        assertEquals(Set.of(1,3), schedule.getWorkWeeks("Jerry"));
        assertEquals(Set.of(2,3), schedule.getWorkWeeks("Romeo"));
        assertEquals(Set.of(2,3), schedule.getWorkWeeks("Juliet"));

    }
}