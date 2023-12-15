package data.structure;

import java.util.ArrayList;
import java.util.Collections;

import checkthat.annotation.IsUsingDefaultConstructor;

@IsUsingDefaultConstructor
public class ListUtil {
    public static ArrayList<Integer> divisors(int number) {
        ArrayList<Integer> retval = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)  retval.add(i);
        }
        return retval;
    }

    public static ArrayList<String> withSameStartEnd(ArrayList<String> txts) {
        ArrayList<String> retval = new ArrayList<>();
        for (String txt : txts) {
            if (txt == null)  continue;
            if (txt.isEmpty())  continue;

            char first = txt.charAt(0);
            char last = txt.charAt(txt.length() - 1);

            if (first != last)    continue;
            retval.add(txt);
        }
        return retval;
    }

    public static void maxToFront(ArrayList<String> txts) {
        if (txts == null)   return;
        if (txts.size() == 0)   return;

        String max = Collections.max(txts);
        txts.remove(max);
        txts.add(0, max);
    }
}
