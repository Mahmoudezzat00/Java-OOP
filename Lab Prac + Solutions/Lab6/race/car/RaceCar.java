package race.car;

public class RaceCar {
    private static int maxIdx;

    public final int idx = ++maxIdx;
    public final SectorTimer sectorTimer;

    private int sectorIdx = 0;

    public RaceCar(int... initSectorTimes) {
        sectorTimer = new SectorTimer(initSectorTimes);
    }

    public void setSectorTime(int time) {
        int[] sectorTimes = sectorTimer.getSectorTimes();
        sectorTimes[sectorIdx] = time;

        sectorTimer.setLapTimes(sectorTimes);

        sectorIdx = (sectorIdx + 1) % sectorTimes.length;
    }

    public static RaceCar getBestCar(int[] sectors, RaceCar... cars) {
        RaceCar retval = null;
        int bestTime = Integer.MAX_VALUE;
        for (RaceCar car : cars) {
            int totalTime = car.getTotalTime(sectors);
            if (totalTime < bestTime) {
                bestTime = totalTime;
                retval = car;
            }
        }
        return retval;
    }

    public int getTotalTime(int[] sectors) {
        int[] sectorTimes = sectorTimer.getSectorTimes();
        int retval = 0;

        for (int i = 0; i < sectors.length; i++) {
            int sector = sectors[i];
            if (sector > sectorTimes.length) {
                throw new IllegalArgumentException("No such sector");
            }
            retval += sectorTimes[sector];
        }

        return retval;
    }
}
