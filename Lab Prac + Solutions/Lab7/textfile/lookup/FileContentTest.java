package textfile.lookup;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FileContentTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
    this_file_does_not_exist.txt, 12, 0
    emptyfile.txt, 12, 0
    sum_input.txt, 12, 2
    """)
    public void contentLineCount(String filename, String content, int foundCount) {
        assertEquals(foundCount, FileContent.contentLineCount(filename, content));
    }

    @Test
    public void contentLineNumbers() {
        assertArrayEquals(new int[] {3,4}, FileContent.contentLineNumbers("sum_input.txt", "12"));
    }
}
