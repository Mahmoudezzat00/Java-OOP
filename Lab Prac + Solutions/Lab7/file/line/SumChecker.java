package file.line;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SumChecker {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("sum_input.txt"));
                PrintWriter pw = new PrintWriter(new File("sum_output.txt"));) {
            String line;
            outer:
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int value = Integer.parseInt(parts[0]);
                int[] numbers = getNumbers(parts[1]);

                for (int i = 0; i < numbers.length - 1; ++i) {
                    for (int j = i + 1; j < numbers.length; ++j) {
                        if (value == numbers[i] + numbers[j]) {
                            pw.printf("%d=%d+%d%n", value, numbers[i], numbers[j]);
                            continue outer;
                        }
                    }
                }

                pw.printf("%d none%n", value);
            }
        } catch (IOException ioe) {
            System.out.println("File not found");
        }
    }

    private static int[] getNumbers(String numsTxt) {
        String[] numsParts = numsTxt.split(",");
        int[] retval = new int[numsParts.length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = Integer.parseInt(numsParts[i]);
        }
        return retval;
    }
}
