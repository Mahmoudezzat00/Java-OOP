package plane.util;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import plane.Circle;

public class CircleUtilTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
        circle1.txt, 0.0, 0.0, 1.0
        circle2.txt, 12.34, -54.12, 54.3
    """)
    public void circle(String filename, double x, double y, double radius) throws FileNotFoundException {
        Circle original = new Circle(x, y, radius);
        CircleUtil.writeCircle(filename, original);
        Circle result = CircleUtil.readCircle(filename);

        assertNotSame(original, result);
        assertEquals(x, result.getX());
        assertEquals(y, result.getY());
        assertEquals(radius, result.getRadius());
    }
}
