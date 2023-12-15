package math.operation.safe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IncrementTest {
	@ParameterizedTest
	@CsvSource(textBlock = """
		0,              1
		2_147_483_647,  2_147_483_647
		-2_147_483_648, -2_147_483_647
		1024,           1025
		-15648,         -15647
	""")
	public void test(int input, int output) {
		assertEquals(output, Increment.increment(input));
	}
}
