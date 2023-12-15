package textfile.lookup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileContent {
    public static int[] contentLineNumbers(String filename, String content) {
        int count = contentLineCount(filename, content);
        int[] retval = new int[count];

        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ) {
            int retIdx = 0;
            int lineIdx = 1;
            while (true) {
                String line = br.readLine();
                if (line == null)   break;

                ++lineIdx;

                if (!line.contains(content))  continue;

                retval[retIdx] = lineIdx-1;
                ++retIdx;
            }
        } catch (IOException e) {
            return new int[0];
        }

        return retval;
    }

    public static int contentLineCount(String filename, String content) {
        int retval = 0;
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ) {
            while (true) {
                String line = br.readLine();
                if (line == null)   break;
                if (line.contains(content))   ++retval;
            }
        } catch (IOException e) {
            return 0;
        }

        return retval;
    }
}
