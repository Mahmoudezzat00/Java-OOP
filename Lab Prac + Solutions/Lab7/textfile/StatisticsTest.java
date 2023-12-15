package textfile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StatisticsTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
    this_file_does_not_exist.txt, 0, 0
    emptyfile.txt, 0, 0
    sum_input.txt, 4, 53
    """)
    public void stats(String filename, int lineCount, int charCount) {
        assertEquals(lineCount, Statistics.numberOfLines(filename));
        assertEquals(charCount, Statistics.numberOfCharacters(filename));
    }
}
