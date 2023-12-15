package math.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PowerTest {

    // @Test(expected = IllegalArgumentException.class)
    // public void testZeroRaisedToNeg()
    // {
    //     MathUtils.power(0, -3);
    // }

    @ParameterizedTest
	@CsvSource(textBlock = """
		2,3,8
		2,0,1
		0,3,0
		1,2342134,1
		0,0,1
        2,-2,0.25
	""")
	public void test(int base, int exp, double expected) {
		assertEquals(expected, Power.power(base,exp));
	}
}