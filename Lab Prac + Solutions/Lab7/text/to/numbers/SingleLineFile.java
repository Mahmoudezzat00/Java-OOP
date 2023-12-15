package text.to.numbers;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class SingleLineFile {
    public static int addNumbers(String fileName) throws IOException {
        String outPutFile = "out.txt";
        try (
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            PrintWriter pw = new PrintWriter(outPutFile);
        ) {
            String line = br.readLine();
            if (line == null) throw new IllegalArgumentException("Empty File");

            String[] parts = line.split(" ");

            int retvalue = 0;
            for(String part:parts) {
                try {
                    retvalue += Integer.parseInt(part);
                } catch(NumberFormatException e) {
                    System.err.println("Invalid: " + part);
                }
            }
            pw.println(retvalue);
            return retvalue;
        }
    }
}