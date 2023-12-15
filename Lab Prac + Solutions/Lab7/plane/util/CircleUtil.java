package plane.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import plane.Circle;

public class CircleUtil {
    public static void writeCircle(String filename, Circle circle) throws FileNotFoundException {
        try (
            PrintWriter pw = new PrintWriter(filename);
        ) {
            pw.println(circle.getX());
            pw.println(circle.getY());
            pw.println(circle.getRadius());
        }
    }

    public static Circle readCircle(String filename) throws FileNotFoundException {
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ) {
            double x = Double.parseDouble(br.readLine());
            double y = Double.parseDouble(br.readLine());
            double radius = Double.parseDouble(br.readLine());

            return new Circle(x, y, radius);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error in file " + filename);
        }
    }
}
