package race.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RaceCarTest {
    @Test
    public void best() {
        RaceCar car1 = new RaceCar(100, 200, 300);
        RaceCar car2 = new RaceCar(300, 200, 50);

        int[] sectors1 = {0,2};

        assertEquals(car2.idx, RaceCar.getBestCar(sectors1, car1, car2).idx);
        assertEquals(car2.idx, RaceCar.getBestCar(sectors1, car2, car1).idx);

        int[] sectors2 = {0,1};

        assertEquals(car1.idx, RaceCar.getBestCar(sectors2, car1, car2).idx);
        assertEquals(car1.idx, RaceCar.getBestCar(sectors2, car2, car1).idx);
    }

    @Test
    public void setIdx() {
        RaceCar car1 = new RaceCar(100, 200, 300);
        RaceCar car2 = new RaceCar(300, 200, 50);

        int[] sectors = {0,2};

        assertEquals(car2.idx, RaceCar.getBestCar(sectors, car1, car2).idx);
        assertEquals(car2.idx, RaceCar.getBestCar(sectors, car2, car1).idx);

        car1.setSectorTime(200);
        car1.setSectorTime(100);
        car1.setSectorTime(49);

        assertEquals(car1.idx, RaceCar.getBestCar(sectors, car1, car2).idx);
        assertEquals(car1.idx, RaceCar.getBestCar(sectors, car2, car1).idx);
    }
}
