package text.util;

import java.util.HashMap;
import java.util.Map.Entry;

public class CharacterStatistics {
    private HashMap<Character, Integer> charToCount;

    public CharacterStatistics(String text) {
        charToCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            int count = 1 + charToCount.getOrDefault(c, 0);
            charToCount.put(c, count);
        }
    }

    public int getCount(char c) {
        return charToCount.getOrDefault(c, 0);
    }

    @Override
    public String toString() {
        StringBuilder retval = new StringBuilder();
        for (Entry<Character, Integer> entry : charToCount.entrySet()) {
            retval.append("%s(%d) ".formatted(entry.getKey(), entry.getValue()));
        }
        return retval.toString();
    }
}
