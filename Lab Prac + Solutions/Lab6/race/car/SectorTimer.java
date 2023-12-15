package race.car;

public class SectorTimer {
	private int[] sectorTimes;

	public SectorTimer(int... sectorTimes) {
		initSectorTimes(sectorTimes);
	}

	public SectorTimer(boolean fake, int... sectorTimes) {
		setSectorTimesV2(sectorTimes);
	}

	public int[] getSectorTimes() {
		int[] retval = new int[sectorTimes.length];
		for (int i = 0; i < retval.length; i++) {
			retval[i] = sectorTimes[i];
		}
		return retval;
	}

	public void setLapTimes(int... sectorTimes) {
		initSectorTimes(sectorTimes);
	}

	private void initSectorTimes(int... sectorTimes) {
		this.sectorTimes = new int[sectorTimes.length];
		for (int i = 0; i < sectorTimes.length; i++) {
			this.sectorTimes[i] = sectorTimes[i];
		}
	}

	public int[] getSectorTimesV2() {
		int[] retval = new int[sectorTimes.length];
		System.arraycopy(sectorTimes, 0, retval, 0, sectorTimes.length);
		return retval;
	}

	public void setSectorTimesV2(int... lapTimes) {
		this.sectorTimes = new int[lapTimes.length];
		System.arraycopy(lapTimes, 0, this.sectorTimes, 0, lapTimes.length);
	}

	public int getSectorTime(int idx) {
		return sectorTimes[idx];
	}
}
