package textfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Statistics {
    public static int numberOfLines(String filename) {
        int retval = 0;
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ) {
            while (true) {
                String line = br.readLine();
                if (line == null)   break;
                ++retval;
            }
        } catch (IOException e) {
            return 0;
        }

        return retval;
    }

    public static int numberOfCharacters(String filename) {
        int retval = 0;
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ) {
            while (true) {
                String line = br.readLine();
                if (line == null)   break;
                retval += line.length();
            }
        } catch (IOException e) {
            return 0;
        }

        return retval;
    }
}
