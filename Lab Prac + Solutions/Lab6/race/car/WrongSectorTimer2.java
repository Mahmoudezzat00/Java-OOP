package race.car;

public class WrongSectorTimer2 {
	private int[] sectorTimes;

	public WrongSectorTimer2(int[] sectorTimes) {
		this.setSectorTimes(sectorTimes);
	}

	public int getLapTime(int idx) {
		return getSectorTimes()[idx];
	}

	public int[] getSectorTimes() {
		return sectorTimes;
	}

	public int getSectorTime(int idx) {
	    return sectorTimes[idx];
	}

	public void setSectorTimes(int[] sectorTimes) {
		this.sectorTimes = sectorTimes;
	}
}
