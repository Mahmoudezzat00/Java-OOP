package race.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WrongSectorTimer1Test {
	@Test
	public void seemsGood() {
		WrongSectorTimer1 timer = new WrongSectorTimer1(new int[] { 1, 2, 3 });
		assertEquals(3, timer.sectorTimes.length);
		assertEquals(1, timer.sectorTimes[0]);
		assertEquals(2, timer.sectorTimes[1]);
		assertEquals(3, timer.sectorTimes[2]);
	}

	@Test
	public void setArrayElemsBreaksEncapsulation() {
		WrongSectorTimer1 timer = new WrongSectorTimer1(new int[] { 1, 2, 3 });
		timer.sectorTimes[0] = 4;
		timer.sectorTimes[1] = 5;
		timer.sectorTimes[2] = 6;
		assertEquals(3, timer.sectorTimes.length);
		assertEquals(4, timer.sectorTimes[0]);
		assertEquals(5, timer.sectorTimes[1]);
		assertEquals(6, timer.sectorTimes[2]);
	}

	@Test
	public void setArrayBreaksEncapsulation() {
		WrongSectorTimer1 timer = new WrongSectorTimer1(new int[] { 1, 2, 3 });
		timer.sectorTimes = new int[] {4,5,6,7};
		assertEquals(4, timer.sectorTimes.length);
		assertEquals(4, timer.sectorTimes[0]);
		assertEquals(5, timer.sectorTimes[1]);
		assertEquals(6, timer.sectorTimes[2]);
		assertEquals(7, timer.sectorTimes[3]);
	}
}
