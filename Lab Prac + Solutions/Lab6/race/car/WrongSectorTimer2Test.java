package race.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WrongSectorTimer2Test {
	@Test
	public void seemsGood() {
		WrongSectorTimer2 timer = new WrongSectorTimer2(new int[] { 1, 2, 3 });

		assertEquals(3, timer.getSectorTimes().length);

		assertEquals(1, timer.getSectorTimes()[0]);
		assertEquals(2, timer.getSectorTimes()[1]);
		assertEquals(3, timer.getSectorTimes()[2]);
	}

	@Test
	public void constructorBreaksEncapsulation() {
		int[] array = new int[] { 1, 2, 3 };

		WrongSectorTimer2 timer = new WrongSectorTimer2(array);

		array[0] = 4;
		array[1] = 5;
		array[2] = 6;

		assertEquals(3, timer.getSectorTimes().length);

		assertEquals(4, timer.getSectorTimes()[0]);
		assertEquals(5, timer.getSectorTimes()[1]);
		assertEquals(6, timer.getSectorTimes()[2]);

		assertEquals(4, timer.getSectorTime(0));
		assertEquals(5, timer.getSectorTime(1));
		assertEquals(6, timer.getSectorTime(2));
	}

	@Test
	public void getterBreaksEncapsulation() {
		WrongSectorTimer2 timer = new WrongSectorTimer2(new int[] { 1, 2, 3 });
		timer.getSectorTimes()[0] = 4;
		timer.getSectorTimes()[1] = 5;
		timer.getSectorTimes()[2] = 6;

		assertEquals(3, timer.getSectorTimes().length);

		assertEquals(4, timer.getSectorTimes()[0]);
		assertEquals(5, timer.getSectorTimes()[1]);
		assertEquals(6, timer.getSectorTimes()[2]);

		assertEquals(4, timer.getSectorTime(0));
		assertEquals(5, timer.getSectorTime(1));
		assertEquals(6, timer.getSectorTime(2));
	}

	@Test
	public void setterBreaksEncapsulation() {
		WrongSectorTimer2 timer = new WrongSectorTimer2(new int[] { 1, 2, 3 });
		int[] localArray = new int[] {4,5,6,7};
		timer.setSectorTimes(localArray);

		localArray[0] = 8;
		localArray[1] = 9;
		localArray[2] = 10;
		localArray[3] = 11;

		assertEquals(4, timer.getSectorTimes().length);

		assertEquals(8, timer.getSectorTimes()[0]);
		assertEquals(9, timer.getSectorTimes()[1]);
		assertEquals(10, timer.getSectorTimes()[2]);
		assertEquals(11, timer.getSectorTimes()[3]);

		assertEquals(8, timer.getSectorTime(0));
		assertEquals(9, timer.getSectorTime(1));
		assertEquals(10, timer.getSectorTime(2));
		assertEquals(11, timer.getSectorTime(3));
	}
}
