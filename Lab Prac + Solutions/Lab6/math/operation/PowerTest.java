package math.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PowerTest {
    //public static final double EPSILON = 0.01;

    @ParameterizedTest
	@CsvSource({"2,3,8", "2,0,1", "0,3,0", "1,34567,1", "0,0,1", "2,-2,0.25", "-2,-2,0.25", "-2,-3,-0.125"})
	public void powerTest(int base, int exp, double expected) {
		assertEquals(expected, Power.power(base,exp));
	}
}