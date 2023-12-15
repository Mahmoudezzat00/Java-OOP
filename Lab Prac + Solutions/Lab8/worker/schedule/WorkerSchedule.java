package worker.schedule;

import java.util.*;
import java.util.Map.Entry;

public class WorkerSchedule {
    private HashMap<Integer, HashSet<String>> weekToWorkers;

    public WorkerSchedule() {
        weekToWorkers = new HashMap<>();
    }

    public void add(int week, HashSet<String> workers) {
        if (!weekToWorkers.containsKey(week-1))
            weekToWorkers.put(week-1, new HashSet<>());

        weekToWorkers.get(week-1).addAll(workers);
    }

    public void add(HashSet<Integer> weeks, ArrayList<String> workers) {
        for (Integer week: weeks) {
            add(week, new HashSet<>(workers));
        }
    }

    public boolean isWorkingOnWeek(String worker, int week) {
        Set<String> workers = weekToWorkers.get(week-1);
        if (workers == null) return false;
        return workers.contains(worker);
    }

    public HashSet<Integer> getWorkWeeks(String worker) { 
        HashSet<Integer> weeks = new HashSet<>();
        for (Entry<Integer, HashSet<String>> entry: weekToWorkers.entrySet()) {
            if (entry.getValue().contains(worker)) {
                weeks.add(entry.getKey() + 1);
            }
        }
        return weeks;
    }

    @Override
    public String toString() {
        return weekToWorkers.toString();
    }

}