package famous.sequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangularNumbersTest {
	@ParameterizedTest
	@CsvSource(textBlock = """
		0, 0
		1, 1
		100, 5050
		-1, 0
		-200, 0
	""")
	public void test(int input, int expected) {
		assertEquals(expected, TriangularNumbers.getTriangularNumber(input));
		assertEquals(expected, TriangularNumbers.getTriangularNumberAlternative(input));
	}
}
