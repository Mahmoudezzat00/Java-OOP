package text.to.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class SingleLineFileTest {
    @Test
    public void file() throws IOException {
        assertEquals(-117, SingleLineFile.addNumbers("numbers.txt"));
    }

    @Test
    public void invalidFile() throws IOException {
        try {
            SingleLineFile.addNumbers("this_file_does_not_exist.txt");
            fail("Invalid file opened");
        } catch (IOException e) {
            System.out.println("This is expected to happen!");
        }
    }

    @Test
    public void emptyFile() throws IOException {
        try {
            SingleLineFile.addNumbers("emptyfile.txt");
            fail("empty file opened");
        } catch(IllegalArgumentException e) {
            assertEquals("Empty File", e.getMessage());
        }
    }
}