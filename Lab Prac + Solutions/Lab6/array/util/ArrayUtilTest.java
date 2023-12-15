package array.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArrayUtilTest {
	@Test
	public void maxLength0() {
		assertEquals(0, ArrayUtil.max(new int[] {}));
		assertEquals(0, ArrayUtil.max2(new int[] {}));
		assertEquals(0, ArrayUtil.max3(new int[] {}));
		assertEquals(0, ArrayUtil.max4(new int[] {}));
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		0
		1
		436234562
		-100
	""")
	public void maxLength1(int elem) {
		assertEquals(elem, ArrayUtil.max(new int[] { elem }));
		assertEquals(elem, ArrayUtil.max2(new int[] { elem }));
		assertEquals(elem, ArrayUtil.max3(new int[] { elem }));
		assertEquals(elem, ArrayUtil.max4(new int[] { elem }));
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		1, 2
		-100, 100
	""")
	public void maxLength2(int min, int max) {
		assertEquals(max, ArrayUtil.max(new int[] { min, max }));
		assertEquals(max, ArrayUtil.max(new int[] { max, min }));

		assertEquals(max, ArrayUtil.max2(new int[] { min, max }));
		assertEquals(max, ArrayUtil.max2(new int[] { max, min }));

		assertEquals(max, ArrayUtil.max3(new int[] { min, max }));
		assertEquals(max, ArrayUtil.max3(new int[] { max, min }));

		assertEquals(max, ArrayUtil.max4(new int[] { min, max }));
		assertEquals(max, ArrayUtil.max4(new int[] { max, min }));
	}

	@Test
	public void minMaxLength0() {
		assertArrayEquals(new int[]{ 0, 0 }, ArrayUtil.minMax(new int[] {}));
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		0
		1
		436234562
		-100
	""")
	public void minMaxLength1(int elem) {
		assertArrayEquals(new int[]{ elem, elem }, ArrayUtil.minMax(new int[] { elem }));
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		1, 2
		-100, 100
	""")
	public void minMaxLength2(int min, int max) {
		assertArrayEquals(new int[]{ min, max }, ArrayUtil.minMax(new int[] { min, max }));
		assertArrayEquals(new int[]{ min, max }, ArrayUtil.minMax(new int[] { max, min }));
	}
}