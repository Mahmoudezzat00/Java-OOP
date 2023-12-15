package text.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CharacterStatisticsTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
                  '', a, 0, ''
            aaaaaaaa, a, 8, 'a(8) '
            HgFeDcBa, F, 1, 'a(1) B(1) c(1) D(1) e(1) F(1) g(1) H(1) '
            a?!_#@{}, ?, 1, '@(1) a(1) !(1) #(1) {(1) }(1) ?(1) _(1) '
        Hello world!, !, 1, ' (1) !(1) r(1) d(1) e(1) w(1) H(1) l(3) o(2) '
    """)
    public void test(String input, char ch, int count, String expected) {
        CharacterStatistics stats = new CharacterStatistics(input);
        assertEquals(count, stats.getCount(ch));
        assertEquals(expected, stats.toString());
    }
}
