package race.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SectorTimerTest {
	@Test
	public void seemsGood() {
		SectorTimer timer = new SectorTimer(new int[] { 1, 2, 3 });

		assertEquals(3, timer.getSectorTimes().length);

		assertEquals(1, timer.getSectorTimes()[0]);
		assertEquals(2, timer.getSectorTimes()[1]);
		assertEquals(3, timer.getSectorTimes()[2]);
	}

	@Test
	public void seemsEvenBetterWithVararg() {
		SectorTimer timer = new SectorTimer(1, 2, 3);

		assertEquals(3, timer.getSectorTimes().length);

		assertEquals(1, timer.getSectorTimes()[0]);
		assertEquals(2, timer.getSectorTimes()[1]);
		assertEquals(3, timer.getSectorTimes()[2]);
	}

	@Test
	public void constructorEncapsulatesWell() {
		int[] array = new int[] { 1, 2, 3 };

		SectorTimer timer = new SectorTimer(array);

		array[0] = 4;
		array[1] = 5;
		array[2] = 6;

		assertEquals(3, timer.getSectorTimes().length);

		assertEquals(1, timer.getSectorTimes()[0]);
		assertEquals(2, timer.getSectorTimes()[1]);
		assertEquals(3, timer.getSectorTimes()[2]);

		assertEquals(1, timer.getSectorTime(0));
		assertEquals(2, timer.getSectorTime(1));
		assertEquals(3, timer.getSectorTime(2));
	}

	@Test
	public void getterEncapsulatesWell() {
		SectorTimer timer = new SectorTimer(new int[] { 1, 2, 3 });
		timer.getSectorTimes()[0] = 4;
		timer.getSectorTimes()[1] = 5;
		timer.getSectorTimes()[2] = 6;

		assertEquals(3, timer.getSectorTimes().length);

		assertEquals(1, timer.getSectorTimes()[0]);
		assertEquals(2, timer.getSectorTimes()[1]);
		assertEquals(3, timer.getSectorTimes()[2]);

		assertEquals(1, timer.getSectorTime(0));
		assertEquals(2, timer.getSectorTime(1));
		assertEquals(3, timer.getSectorTime(2));
	}

	@Test
	public void getter2EncapsulatesWell() {
		SectorTimer timer = new SectorTimer(1, 2, 3);
		timer.getSectorTimesV2()[0] = 4;
		timer.getSectorTimesV2()[1] = 5;
		timer.getSectorTimesV2()[2] = 6;

		assertEquals(3, timer.getSectorTimesV2().length);

		assertEquals(1, timer.getSectorTimesV2()[0]);
		assertEquals(2, timer.getSectorTimesV2()[1]);
		assertEquals(3, timer.getSectorTimesV2()[2]);

		assertEquals(1, timer.getSectorTime(0));
		assertEquals(2, timer.getSectorTime(1));
		assertEquals(3, timer.getSectorTime(2));
	}

	@Test
	public void setterEncapsulatesWell() {
		SectorTimer timer = new SectorTimer(1, 2, 3);
		int[] localArray = new int[] {4,5,6,7};
		timer.setLapTimes(localArray);

		localArray[0] = 8;
		localArray[1] = 9;
		localArray[2] = 10;
		localArray[3] = 11;

		assertEquals(4, timer.getSectorTimes().length);

		assertEquals(4, timer.getSectorTimes()[0]);
		assertEquals(5, timer.getSectorTimes()[1]);
		assertEquals(6, timer.getSectorTimes()[2]);
		assertEquals(7, timer.getSectorTimes()[3]);

		assertEquals(4, timer.getSectorTime(0));
		assertEquals(5, timer.getSectorTime(1));
		assertEquals(6, timer.getSectorTime(2));
		assertEquals(7, timer.getSectorTime(3));
	}

	@Test
	public void setter2EncapsulatesWell() {
		SectorTimer timer = new SectorTimer(new int[] { 1, 2, 3 });
		int[] localArray = new int[] {4,5,6,7};
		timer.setSectorTimesV2(localArray);

		localArray[0] = 8;
		localArray[1] = 9;
		localArray[2] = 10;
		localArray[3] = 11;

		assertEquals(4, timer.getSectorTimes().length);

		assertEquals(4, timer.getSectorTimes()[0]);
		assertEquals(5, timer.getSectorTimes()[1]);
		assertEquals(6, timer.getSectorTimes()[2]);
		assertEquals(7, timer.getSectorTimes()[3]);

		assertEquals(4, timer.getSectorTime(0));
		assertEquals(5, timer.getSectorTime(1));
		assertEquals(6, timer.getSectorTime(2));
		assertEquals(7, timer.getSectorTime(3));
	}
}
