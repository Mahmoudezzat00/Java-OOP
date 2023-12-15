package math.operation.textual;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AdderTest {
	@ParameterizedTest
	@CsvSource(textBlock = """
		blah, blah
		123, blah
		not a number, 234.01
	""")
	public void wrongInput(String op1, String op2) {
		assertEquals("Operands are not numbers", new Adder().addAsText(op1, op2));
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		0,    0, 0
		123,  0, 123
		-352, 0, -352
		0,    0.0, 0.0
		123,  0.0, 123.0
		-352, 0.0, -352.0
	""")
	public void addZero(String op, String zero, String expected) {
		assertEquals(expected, new Adder().addAsText(op, zero));
		assertEquals(expected, new Adder().addAsText(zero, op));
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		0,    0, 0
		123,  0, 123
		-352, 0, -352
		0,    0.0, 0.0
		123,  0.0, 123.0
		-352, 0.0, -352.0
	""")
	public void add(String op1, String op2, String expected) {
		assertEquals(expected, new Adder().addAsText(op1, op2));
		assertEquals(expected, new Adder().addAsText(op2, op1));
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		123,  -123
		-352, 100
		123.0,  -123
		-352, 100.0
	""")
	public void addCommutative(String op1, String op2) {
		assertEquals(new Adder().addAsText(op2, op1), new Adder().addAsText(op1, op2));
		assertEquals(new Adder().addAsText(op1, op2), new Adder().addAsText(op2, op1));
	}
}
