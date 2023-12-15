package cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarCipherTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
    a,     1,b
    abc,   1,bcd
    z,     2, b
    """)
    public void encryptBy(String input, int shift, String expected) {
        assertEquals(expected, new CaesarCipher(shift).encrypt(input));
    }
}